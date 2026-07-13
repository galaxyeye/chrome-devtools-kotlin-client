package ai.platon.browser4.chrome.protocol

import ai.platon.browser4.api.BrowserProtocol
import ai.platon.browser4.chrome.BrowserDevTools
import ai.platon.browser4.chrome.protocol.transport.DevToolsInvocationHandler
import ai.platon.browser4.chrome.protocol.events.console.MessageAdded
import ai.platon.browser4.chrome.protocol.events.fetch.AuthRequired
import ai.platon.browser4.chrome.protocol.events.fetch.RequestPaused
import ai.platon.browser4.chrome.protocol.events.input.DragIntercepted
import ai.platon.browser4.chrome.protocol.events.network.*
import ai.platon.browser4.chrome.protocol.events.page.DocumentOpened
import ai.platon.browser4.chrome.protocol.events.page.FrameNavigated
import ai.platon.browser4.chrome.protocol.events.page.WindowOpen
import ai.platon.browser4.chrome.protocol.support.EventHandler
import ai.platon.browser4.chrome.protocol.support.EventListener
import ai.platon.browser4.chrome.protocol.types.accessibility.AXNode
import ai.platon.browser4.chrome.protocol.types.css.CSSComputedStyleProperty
import ai.platon.browser4.chrome.protocol.types.dom.BoxModel
import ai.platon.browser4.chrome.protocol.types.dom.Node
import ai.platon.browser4.chrome.protocol.types.dom.PerformSearch
import ai.platon.browser4.chrome.protocol.types.dom.Rect
import ai.platon.browser4.chrome.protocol.types.domsnapshot.CaptureSnapshot
import ai.platon.browser4.chrome.protocol.types.fetch.AuthChallengeResponse
import ai.platon.browser4.chrome.protocol.types.fetch.HeaderEntry
import ai.platon.browser4.chrome.protocol.types.fetch.RequestPattern
import ai.platon.browser4.chrome.protocol.types.fetch.ResponseBody
import ai.platon.browser4.chrome.protocol.types.input.*
import ai.platon.browser4.chrome.protocol.types.network.Cookie
import ai.platon.browser4.chrome.protocol.types.network.ErrorReason
import ai.platon.browser4.chrome.protocol.types.network.LoadNetworkResourceOptions
import ai.platon.browser4.chrome.protocol.types.network.LoadNetworkResourcePageResult
import ai.platon.browser4.chrome.protocol.types.page.*
import ai.platon.browser4.chrome.protocol.types.runtime.CallArgument
import ai.platon.browser4.chrome.protocol.types.runtime.CallFunctionOn
import ai.platon.browser4.chrome.protocol.types.runtime.Evaluate
import ai.platon.browser4.chrome.protocol.types.runtime.RemoteObject
import ai.platon.pulsar.common.getLogger
import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

@Serializable
data class EmptyResult(
    val ignored: String? = null
)

/**
 * CDP is the single access point for all Chrome DevTools Protocol (CDP) domain APIs.
 *
 * All CDP method invocations go through [BrowserDevTools.execute] or [BrowserDevTools.invoke]
 * directly using string method names. No reflection-based proxy needed.
 *
 * Event subscriptions use [BrowserDevTools.addEventListener] directly with string domain/event names.
 */
class DirectChromeProtocol(
    val devTools: BrowserDevTools
) : BrowserProtocol {

    private val logger = getLogger(this)

    override val isOpen: Boolean get() = devTools.isOpen

    // ---------------------------------------------------------------------------
    // Private helpers — non-reflective CDP command dispatch
    // ---------------------------------------------------------------------------

    /** Execute a CDP command with no meaningful return value. */
    private suspend fun command(method: String, params: Map<String, Any?>? = null) {
        devTools.execute(method, params, EmptyResult::class)
    }

    /** Execute a CDP command returning a deserialized result. */
    private suspend inline fun <reified T : Any> command(
        method: String,
        params: Map<String, Any?>? = null,
        returnProperty: String? = null,
    ): T? = devTools.execute(method, params, T::class, returnProperty)

    /**
     * Execute a CDP command with a degraded fallback when deserialization fails
     * (e.g. because the Chrome protocol version changed and fields expected by
     * the Kotlin data class are missing from the response).
     */
    private suspend inline fun <reified T : Any> commandResilient(
        method: String,
        params: Map<String, Any?>? = null,
        returnProperty: String? = null,
        crossinline degraded: () -> T,
    ): T {
        return command<T>(method, params, returnProperty) ?: run {
            logger.warn("CDP '{}' response failed to deserialize — using degraded fallback", method)
            degraded()
        }
    }

    /**
     * Execute a CDP command that returns a typed list.
     * Uses the full [RemoteDevTools.invoke] to preserve generic element type info.
     */
    @Suppress("UNCHECKED_CAST")
    private suspend fun <T> listCommand(
        method: String,
        params: Map<String, Any?>?,
        elementClass: KClass<*>,
        returnProperty: String,
    ): List<T> {
        val invocation = DevToolsInvocationHandler.createMethodInvocation(method, params)
        val typeArgs = arrayOf<KClass<*>>(elementClass)
        return devTools.invoke(
            List::class, returnProperty, typeArgs, invocation
        ) as List<T>
    }

    /**
     * Execute a CDP command that returns a nested typed list (e.g. List<List<Double>>).
     */
    @Suppress("UNCHECKED_CAST")
    private suspend fun <T> nestedListCommand(
        method: String,
        params: Map<String, Any?>?,
        elementClass: KClass<*>,
        returnProperty: String,
    ): List<List<T>> {
        val invocation = DevToolsInvocationHandler.createMethodInvocation(method, params)
        val typeArgs = arrayOf<KClass<*>>(List::class, elementClass)
        return devTools.invoke(
            List::class, returnProperty, typeArgs, invocation
        ) as List<List<T>>
    }

    /** Subscribe to a CDP event without going through the reflection proxy. */
    private fun <T : Any> onEvent(
        domain: String,
        event: String,
        eventType: KClass<T>,
        handler: suspend (T) -> Unit,
    ): EventListener {
        return devTools.addEventListener(
            domain, event,
            EventHandler { event -> handler(event as T) },
            eventType,
        )
    }

    /** Build a params map, dropping null-valued entries. */
    private fun params(block: MutableMap<String, Any?>.() -> Unit): Map<String, Any?> {
        return mutableMapOf<String, Any?>().apply(block)
    }

    // ---------------------------------------------------------------------------
    // Health checks
    // ---------------------------------------------------------------------------

    override suspend fun isBrowserAlive(): Boolean {
        return runCatching { command("Browser.getVersion") }.isSuccess
    }

    override suspend fun isTargetAlive(): Boolean {
        return runCatching { command("Target.getTargets") }.isSuccess
    }

    override suspend fun isV8Alive(): Boolean {
        return runCatching {
            command("Runtime.evaluate", mapOf("expression" to "1+1"))
        }.isSuccess
    }

    // ---------------------------------------------------------------------------
    // Page domain
    // ---------------------------------------------------------------------------

    override suspend fun mainFrame() =
        commandResilient("Page.getFrameTree", returnProperty = "frameTree") { FrameTree.degraded() }.frame

    override suspend fun pageEnable() = command("Page.enable")
    override suspend fun domEnable() = command("DOM.enable")
    override suspend fun accessibilityEnable() = command("Accessibility.enable")
    override suspend fun runtimeEnable() = command("Runtime.enable")
    override suspend fun networkEnable() = command("Network.enable")
    override suspend fun cssEnable() = command("CSS.enable")
    override suspend fun fetchEnable() = command("Fetch.enable")

    override suspend fun fetchEnable(patterns: List<RequestPattern>, handleAuthRequests: Boolean) {
        command("Fetch.enable", mapOf("patterns" to patterns, "handleAuthRequests" to handleAuthRequests))
    }

    override suspend fun securityEnable() = command("Security.enable")

    override suspend fun getFrameTree() =
        commandResilient("Page.getFrameTree", returnProperty = "frameTree") { FrameTree.degraded() }

    override suspend fun reload() = command("Page.reload")
    override suspend fun navigateToHistoryEntry(entryId: Int) {
        command("Page.navigateToHistoryEntry", mapOf("entryId" to entryId))
    }

    override suspend fun handleJavaScriptDialog(accept: Boolean, promptText: String?) {
        command(
            "Page.handleJavaScriptDialog",
            params {
                put("accept", accept)
                promptText?.let { put("promptText", it) }
            }
        )
    }

    override suspend fun bringToFront() = command("Page.bringToFront")
    override suspend fun stopLoading() = command("Page.stopLoading")

    override suspend fun addScriptToEvaluateOnNewDocument(script: String): String {
        // CDP parameter name is "source", not "script"
        return command<String>(
            "Page.addScriptToEvaluateOnNewDocument",
            mapOf("source" to script),
            returnProperty = "identifier"
        ) ?: run {
            logger.warn("CDP 'Page.addScriptToEvaluateOnNewDocument' response failed to deserialize")
            ""
        }
    }

    override fun onDocumentOpened(handler: suspend (DocumentOpened) -> Unit) =
        onEvent("Page", "documentOpened", DocumentOpened::class, handler)

    override fun onFrameNavigated(handler: suspend (FrameNavigated) -> Unit) =
        onEvent("Page", "frameNavigated", FrameNavigated::class, handler)

    override fun onWindowOpen(handler: suspend (WindowOpen) -> Unit) =
        onEvent("Page", "windowOpen", WindowOpen::class, handler)

    override suspend fun navigate(url: String): Navigate {
        return commandResilient("Page.navigate", mapOf("url" to url)) { Navigate.degraded() }
    }

    override suspend fun navigate(
        url: String,
        referrer: String?,
        transitionType: TransitionType?,
        frameId: String?,
        referrerPolicy: ReferrerPolicy?,
    ): Navigate {
        return commandResilient(
            "Page.navigate",
            params {
                put("url", url)
                referrer?.let { put("referrer", it) }
                transitionType?.let { put("transitionType", it) }
                frameId?.let { put("frameId", it) }
                referrerPolicy?.let { put("referrerPolicy", it) }
            }
        ) { Navigate.degraded() }
    }

    // ---------------------------------------------------------------------------
    // Runtime domain
    // ---------------------------------------------------------------------------

    override suspend fun evaluate(
        expression: String,
        contextId: Int?,
        returnByValue: Boolean?,
        awaitPromise: Boolean?,
    ): Evaluate {
        return commandResilient(
            "Runtime.evaluate",
            params {
                put("expression", expression)
                contextId?.let { put("contextId", it) }
                returnByValue?.let { put("returnByValue", it) }
                awaitPromise?.let { put("awaitPromise", it) }
            }
        ) { Evaluate.degraded() }
    }

    override suspend fun callFunctionOn(
        functionDeclaration: String,
        objectId: String?,
        arguments: List<CallArgument>?,
        silent: Boolean?,
        returnByValue: Boolean?,
        generatePreview: Boolean?,
        userGesture: Boolean?,
        awaitPromise: Boolean?,
        executionContextId: Int?,
        objectGroup: String?,
    ): CallFunctionOn {
        return commandResilient(
            "Runtime.callFunctionOn",
            params {
                put("functionDeclaration", functionDeclaration)
                objectId?.let { put("objectId", it) }
                arguments?.let { put("arguments", it) }
                silent?.let { put("silent", it) }
                returnByValue?.let { put("returnByValue", it) }
                generatePreview?.let { put("generatePreview", it) }
                userGesture?.let { put("userGesture", it) }
                awaitPromise?.let { put("awaitPromise", it) }
                executionContextId?.let { put("executionContextId", it) }
                objectGroup?.let { put("objectGroup", it) }
            }
        ) { CallFunctionOn.degraded() }
    }

    override suspend fun releaseObject(objectId: String) {
        command("Runtime.releaseObject", mapOf("objectId" to objectId))
    }

    // ---------------------------------------------------------------------------
    // Page domain (continued)
    // ---------------------------------------------------------------------------

    override suspend fun getLayoutMetrics() =
        commandResilient("Page.getLayoutMetrics") { LayoutMetrics.degraded() }

    override suspend fun getNavigationHistory() =
        commandResilient("Page.getNavigationHistory") { NavigationHistory.degraded() }

    override suspend fun createIsolatedWorld(frameId: String, worldName: String, grantUniveralAccess: Boolean): Int {
        return command<Int>(
            "Page.createIsolatedWorld",
            mapOf(
                "frameId" to frameId,
                "worldName" to worldName,
                "grantUniveralAccess" to grantUniveralAccess, // matches CDP spec typo
            ),
            returnProperty = "executionContextId"
        ) ?: run {
            logger.warn("CDP 'Page.createIsolatedWorld' response failed to deserialize")
            0
        }
    }

    override suspend fun captureScreenshot(
        format: CaptureScreenshotFormat?,
        quality: Int?,
        clip: Viewport?,
        fromSurface: Boolean?,
        captureBeyondViewport: Boolean?,
    ): String {
        return command<String>(
            "Page.captureScreenshot",
            params {
                format?.let { put("format", it) }
                quality?.let { put("quality", it) }
                clip?.let { put("clip", it) }
                fromSurface?.let { put("fromSurface", it) }
                captureBeyondViewport?.let { put("captureBeyondViewport", it) }
            },
            returnProperty = "data"
        ) ?: run {
            logger.warn("CDP 'Page.captureScreenshot' response failed to deserialize")
            ""
        }
    }

    // ---------------------------------------------------------------------------
    // Emulation domain
    // ---------------------------------------------------------------------------

    override suspend fun setDeviceMetricsOverride(
        mobile: Boolean,
        width: Int,
        height: Int,
        deviceScaleFactor: Double,
        screenWidth: Int?,
        screenHeight: Int?,
    ) {
        command(
            "Emulation.setDeviceMetricsOverride",
            params {
                put("mobile", mobile)
                put("width", width)
                put("height", height)
                put("deviceScaleFactor", deviceScaleFactor)
                screenWidth?.let { put("screenWidth", it) }
                screenHeight?.let { put("screenHeight", it) }
            }
        )
    }

    override suspend fun clearDeviceMetricsOverride() = command("Emulation.clearDeviceMetricsOverride")

    // ---------------------------------------------------------------------------
    // DOM domain
    // ---------------------------------------------------------------------------

    override suspend fun getDocument(depth: Int?, pierce: Boolean?): Node {
        return commandResilient(
            "DOM.getDocument",
            params {
                depth?.let { put("depth", it) }
                pierce?.let { put("pierce", it) }
            },
            returnProperty = "root"
        ) { Node.degraded() }
    }

    override suspend fun getContentQuads(nodeId: Int): List<List<Double>> {
        return nestedListCommand(
            "DOM.getContentQuads",
            mapOf("nodeId" to nodeId),
            Double::class,
            "quads"
        )
    }

    override suspend fun getBoxModel(nodeId: Int): BoxModel {
        return commandResilient(
            "DOM.getBoxModel", mapOf("nodeId" to nodeId), returnProperty = "model"
        ) { BoxModel.degraded() }
    }

    override suspend fun querySelector(nodeId: Int, selector: String): Int {
        return command<Int>(
            "DOM.querySelector",
            mapOf("nodeId" to nodeId, "selector" to selector),
            returnProperty = "nodeId"
        ) ?: run {
            logger.warn("CDP 'DOM.querySelector' response failed to deserialize")
            0
        }
    }

    override suspend fun querySelectorAll(nodeId: Int, selector: String): List<Int> {
        return listCommand(
            "DOM.querySelectorAll",
            mapOf("nodeId" to nodeId, "selector" to selector),
            Int::class,
            "nodeIds"
        )
    }

    override suspend fun performSearch(query: String, includeUserAgentShadowDOM: Boolean?): PerformSearch {
        return commandResilient(
            "DOM.performSearch",
            params {
                put("query", query)
                includeUserAgentShadowDOM?.let { put("includeUserAgentShadowDOM", it) }
            }
        ) { PerformSearch.degraded() }
    }

    override suspend fun getSearchResults(searchId: String, fromIndex: Int, toIndex: Int): List<Int> {
        return listCommand(
            "DOM.getSearchResults",
            mapOf("searchId" to searchId, "fromIndex" to fromIndex, "toIndex" to toIndex),
            Int::class,
            "nodeIds"
        )
    }

    override suspend fun discardSearchResults(searchId: String) {
        command("DOM.discardSearchResults", mapOf("searchId" to searchId))
    }

    override suspend fun getAttributes(nodeId: Int): List<String> {
        return listCommand(
            "DOM.getAttributes", mapOf("nodeId" to nodeId), String::class, "attributes"
        )
    }

    override suspend fun focus(nodeId: Int) {
        command("DOM.focus", mapOf("nodeId" to nodeId))
    }

    override suspend fun describeNode(
        nodeId: Int?,
        backendNodeId: Int?,
        objectId: String?,
        depth: Int?,
        pierce: Boolean?,
    ): Node {
        return commandResilient(
            "DOM.describeNode",
            params {
                nodeId?.let { put("nodeId", it) }
                backendNodeId?.let { put("backendNodeId", it) }
                objectId?.let { put("objectId", it) }
                depth?.let { put("depth", it) }
                pierce?.let { put("pierce", it) }
            },
            returnProperty = "node"
        ) { Node.degraded() }
    }

    override suspend fun scrollIntoViewIfNeeded(
        nodeId: Int, backendNodeId: Int?, objectId: String?, rect: Rect?
    ) {
        command(
            "DOM.scrollIntoViewIfNeeded",
            params {
                put("nodeId", nodeId)
                backendNodeId?.let { put("backendNodeId", it) }
                objectId?.let { put("objectId", it) }
                rect?.let { put("rect", it) }
            }
        )
    }

    override suspend fun resolveNodeByNodeId(nodeId: Int): RemoteObject {
        return commandResilient(
            "DOM.resolveNode", mapOf("nodeId" to nodeId), returnProperty = "object"
        ) { RemoteObject.degraded() }
    }

    override suspend fun resolveNodeByBackendNodeId(backendNodeId: Int): RemoteObject {
        return commandResilient(
            "DOM.resolveNode", mapOf("backendNodeId" to backendNodeId), returnProperty = "object"
        ) { RemoteObject.degraded() }
    }

    override suspend fun requestNode(objectId: String): Int {
        return command<Int>(
            "DOM.requestNode", mapOf("objectId" to objectId), returnProperty = "nodeId"
        ) ?: run {
            logger.warn("CDP 'DOM.requestNode' response failed to deserialize")
            0
        }
    }

    // ---------------------------------------------------------------------------
    // CSS domain
    // ---------------------------------------------------------------------------

    override suspend fun getComputedStyleForNode(nodeId: Int): List<CSSComputedStyleProperty> {
        return listCommand(
            "CSS.getComputedStyleForNode",
            mapOf("nodeId" to nodeId),
            CSSComputedStyleProperty::class,
            "computedStyle"
        )
    }

    // ---------------------------------------------------------------------------
    // Accessibility domain
    // ---------------------------------------------------------------------------

    override suspend fun getFullAXTree(depth: Int?): List<AXNode> {
        return listCommand(
            "Accessibility.getFullAXTree",
            params { depth?.let { put("depth", it) } },
            AXNode::class,
            "nodes"
        )
    }

    // ---------------------------------------------------------------------------
    // Network domain
    // ---------------------------------------------------------------------------

    override suspend fun clearBrowserCookies() = command("Network.clearBrowserCookies")

    override suspend fun setBlockedURLs(urls: List<String>) {
        command("Network.setBlockedURLs", mapOf("urls" to urls))
    }

    override suspend fun getCookies(): List<Cookie> {
        return listCommand("Network.getCookies", null, Cookie::class, "cookies")
    }

    override suspend fun deleteCookies(name: String, url: String?, domain: String?, path: String?) {
        command(
            "Network.deleteCookies",
            params {
                put("name", name)
                url?.let { put("url", it) }
                domain?.let { put("domain", it) }
                path?.let { put("path", it) }
            }
        )
    }

    override suspend fun loadNetworkResource(
        frameId: String, url: String, options: LoadNetworkResourceOptions
    ): LoadNetworkResourcePageResult {
        return commandResilient(
            "Network.loadNetworkResource",
            mapOf("frameId" to frameId, "url" to url, "options" to options),
            returnProperty = "resource"
        ) { LoadNetworkResourcePageResult.degraded() }
    }

    override suspend fun setExtraHTTPHeaders(headers: Map<String, Any>) {
        command("Network.setExtraHTTPHeaders", mapOf("headers" to headers))
    }

    override suspend fun setCacheDisabled(cacheDisabled: Boolean) {
        command("Network.setCacheDisabled", mapOf("cacheDisabled" to cacheDisabled))
    }

    override fun onRequestWillBeSent(handler: suspend (RequestWillBeSent) -> Unit) =
        onEvent("Network", "requestWillBeSent", RequestWillBeSent::class, handler)

    override fun onRequestWillBeSentExtraInfo(handler: suspend (RequestWillBeSentExtraInfo) -> Unit) =
        onEvent("Network", "requestWillBeSentExtraInfo", RequestWillBeSentExtraInfo::class, handler)

    override fun onRequestServedFromCache(handler: suspend (RequestServedFromCache) -> Unit) =
        onEvent("Network", "requestServedFromCache", RequestServedFromCache::class, handler)

    override fun onResponseReceived(handler: suspend (ResponseReceived) -> Unit) =
        onEvent("Network", "responseReceived", ResponseReceived::class, handler)

    override fun onResponseReceivedExtraInfo(handler: suspend (ResponseReceivedExtraInfo) -> Unit) =
        onEvent("Network", "responseReceivedExtraInfo", ResponseReceivedExtraInfo::class, handler)

    override fun onLoadingFinished(handler: suspend (LoadingFinished) -> Unit) =
        onEvent("Network", "loadingFinished", LoadingFinished::class, handler)

    override fun onLoadingFailed(handler: suspend (LoadingFailed) -> Unit) =
        onEvent("Network", "loadingFailed", LoadingFailed::class, handler)

    // ---------------------------------------------------------------------------
    // Fetch domain
    // ---------------------------------------------------------------------------

    override suspend fun failRequest(requestId: String, errorReason: ErrorReason) {
        command("Fetch.failRequest", mapOf("requestId" to requestId, "errorReason" to errorReason))
    }

    override suspend fun getResponseBody(requestId: String): ResponseBody {
        return commandResilient(
            "Fetch.getResponseBody", mapOf("requestId" to requestId)
        ) { ResponseBody.degraded() }
    }

    override suspend fun setFileInputFiles(files: List<String>, nodeId: Int) {
        command("DOM.setFileInputFiles", mapOf("files" to files, "nodeId" to nodeId))
    }

    override suspend fun getOuterHTML(nodeId: Int, backendNodeId: Int, objectId: String?): String {
        return command<String>(
            "DOM.getOuterHTML",
            params {
                put("nodeId", nodeId)
                put("backendNodeId", backendNodeId)
                objectId?.let { put("objectId", it) }
            },
            returnProperty = "outerHTML"
        ) ?: run {
            logger.warn("CDP 'DOM.getOuterHTML' response failed to deserialize")
            ""
        }
    }

    override fun onDragIntercepted(handler: (DragIntercepted) -> Unit) =
        onEvent("Input", "dragIntercepted", DragIntercepted::class, handler)

    // ---------------------------------------------------------------------------
    // Input domain — mouse
    // ---------------------------------------------------------------------------

    override suspend fun dispatchMouseMoved(x: Double, y: Double, buttons: Int?) {
        command(
            "Input.dispatchMouseEvent",
            params {
                put("type", DispatchMouseEventType.MOUSE_MOVED)
                put("x", x)
                put("y", y)
                buttons?.let { put("buttons", it) }
            }
        )
    }

    override suspend fun dispatchMousePressed(
        x: Double, y: Double, clickCount: Int, modifiers: Int?, buttons: Int
    ) {
        command(
            "Input.dispatchMouseEvent",
            params {
                put("type", DispatchMouseEventType.MOUSE_PRESSED)
                put("x", x)
                put("y", y)
                put("button", MouseButton.LEFT)
                modifiers?.let { put("modifiers", it) }
                put("buttons", buttons)
                put("clickCount", clickCount)
                put("force", 0.5)
            }
        )
    }

    override suspend fun dispatchMouseReleased(
        x: Double, y: Double, clickCount: Int, modifiers: Int?, buttons: Int
    ) {
        command(
            "Input.dispatchMouseEvent",
            params {
                put("type", DispatchMouseEventType.MOUSE_RELEASED)
                put("x", x)
                put("y", y)
                put("button", MouseButton.LEFT)
                put("clickCount", clickCount)
                modifiers?.let { put("modifiers", it) }
                put("buttons", buttons)
            }
        )
    }

    override suspend fun dispatchMouseWheel(x: Double, y: Double, deltaX: Double, deltaY: Double) {
        command(
            "Input.dispatchMouseEvent",
            mapOf(
                "type" to DispatchMouseEventType.MOUSE_WHEEL,
                "x" to x,
                "y" to y,
                "deltaX" to deltaX,
                "deltaY" to deltaY,
            )
        )
    }

    override suspend fun setInterceptDrags(enabled: Boolean) {
        command("Input.setInterceptDrags", mapOf("enabled" to enabled))
    }

    override suspend fun dispatchDragEvent(type: DispatchDragEventType, x: Double, y: Double, data: DragData) {
        command(
            "Input.dispatchDragEvent",
            mapOf("type" to type, "x" to x, "y" to y, "data" to data)
        )
    }

    override suspend fun insertText(text: String) {
        command("Input.insertText", mapOf("text" to text))
    }

    // ---------------------------------------------------------------------------
    // Input domain — keyboard
    // ---------------------------------------------------------------------------

    override suspend fun dispatchKeyEvent(
        type: DispatchKeyEventType,
        modifiers: Int?,
        windowsVirtualKeyCode: Int?,
        code: String?,
        commands: List<String>?,
        key: String?,
        text: String?,
        unmodifiedText: String?,
        location: Int?,
        isKeypad: Boolean?,
        autoRepeat: Boolean?,
    ) {
        command(
            "Input.dispatchKeyEvent",
            params {
                put("type", type)
                modifiers?.let { put("modifiers", it) }
                windowsVirtualKeyCode?.let { put("windowsVirtualKeyCode", it) }
                code?.let { put("code", it) }
                commands?.let { put("commands", it) }
                key?.let { put("key", it) }
                text?.let { put("text", it) }
                unmodifiedText?.let { put("unmodifiedText", it) }
                location?.let { put("location", it) }
                isKeypad?.let { put("isKeypad", it) }
                autoRepeat?.let { put("autoRepeat", it) }
            }
        )
    }

    // ---------------------------------------------------------------------------
    // DOMSnapshot domain
    // ---------------------------------------------------------------------------

    override suspend fun domSnapshotCaptureSnapshot(
        computedStyles: List<String>,
        includePaintOrder: Boolean?,
        includeDOMRects: Boolean?,
        includeBlendedBackgroundColors: Boolean?,
        includeTextColorOpacities: Boolean?,
    ): CaptureSnapshot {
        return commandResilient(
            "DOMSnapshot.captureSnapshot",
            params {
                put("computedStyles", computedStyles)
                includePaintOrder?.let { put("includePaintOrder", it) }
                includeDOMRects?.let { put("includeDOMRects", it) }
                includeBlendedBackgroundColors?.let { put("includeBlendedBackgroundColors", it) }
                includeTextColorOpacities?.let { put("includeTextColorOpacities", it) }
            }
        ) { CaptureSnapshot.degraded() }
    }

    // ---------------------------------------------------------------------------
    // Page domain — reload with options
    // ---------------------------------------------------------------------------

    override suspend fun reloadPage(ignoreCache: Boolean?, scriptToEvaluateOnLoad: String?) {
        command(
            "Page.reload",
            params {
                ignoreCache?.let { put("ignoreCache", it) }
                scriptToEvaluateOnLoad?.let { put("scriptToEvaluateOnLoad", it) }
            }
        )
    }

    // ---------------------------------------------------------------------------
    // Network domain — cookies (already on the target path as the exemplar)
    // ---------------------------------------------------------------------------

    override suspend fun setCookies(cookies: List<Map<String, Any?>>) {
        command("Network.setCookies", mapOf("cookies" to cookies))
    }

    // ---------------------------------------------------------------------------
    // Fetch domain — interception
    // ---------------------------------------------------------------------------

    override suspend fun continueRequest(
        requestId: String,
        url: String?,
        method: String?,
        postData: String?,
        headers: List<HeaderEntry>?,
    ) {
        command(
            "Fetch.continueRequest",
            params {
                put("requestId", requestId)
                url?.let { put("url", it) }
                method?.let { put("method", it) }
                postData?.let { put("postData", it) }
                headers?.let { put("headers", it) }
            }
        )
    }

    override suspend fun continueWithAuth(requestId: String, authChallengeResponse: AuthChallengeResponse) {
        command(
            "Fetch.continueWithAuth",
            mapOf("requestId" to requestId, "authChallengeResponse" to authChallengeResponse)
        )
    }

    override suspend fun fulfillRequest(
        requestId: String,
        responseCode: Int,
        responseHeaders: List<HeaderEntry>?,
        binaryResponseHeaders: String?,
        body: String?,
        responsePhrase: String?,
    ) {
        command(
            "Fetch.fulfillRequest",
            params {
                put("requestId", requestId)
                put("responseCode", responseCode)
                responseHeaders?.let { put("responseHeaders", it) }
                binaryResponseHeaders?.let { put("binaryResponseHeaders", it) }
                body?.let { put("body", it) }
                responsePhrase?.let { put("responsePhrase", it) }
            }
        )
    }

    override fun onRequestPaused(handler: suspend (RequestPaused) -> Unit) =
        onEvent("Fetch", "requestPaused", RequestPaused::class, handler)

    override fun onAuthRequired(handler: suspend (AuthRequired) -> Unit) =
        onEvent("Fetch", "authRequired", AuthRequired::class, handler)

    // ---------------------------------------------------------------------------
    // Security domain
    // ---------------------------------------------------------------------------

    override suspend fun setIgnoreCertificateErrors(ignore: Boolean) {
        command("Security.setIgnoreCertificateErrors", mapOf("ignore" to ignore))
    }

    // ---------------------------------------------------------------------------
    // Console domain
    // ---------------------------------------------------------------------------

    override fun onConsoleMessageAdded(handler: suspend (MessageAdded) -> Unit) =
        onEvent("Console", "messageAdded", MessageAdded::class, handler)

    // ---------------------------------------------------------------------------
    // Lifecycle
    // ---------------------------------------------------------------------------

    override fun awaitTermination() {
        devTools.awaitTermination()
    }

    override fun close() {
        devTools.close()
    }
}
