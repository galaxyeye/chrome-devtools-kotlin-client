package ai.platon.pulsar.browser.driver.chrome.impl

import ai.platon.cdt.kt.serialization.protocol.events.console.MessageAdded
import ai.platon.cdt.kt.serialization.protocol.events.network.LoadingFailed
import ai.platon.cdt.kt.serialization.protocol.events.network.LoadingFinished
import ai.platon.cdt.kt.serialization.protocol.events.network.RequestServedFromCache
import ai.platon.cdt.kt.serialization.protocol.events.network.RequestWillBeSent
import ai.platon.cdt.kt.serialization.protocol.events.network.ResponseReceived
import ai.platon.cdt.kt.serialization.protocol.events.page.DocumentOpened
import ai.platon.cdt.kt.serialization.protocol.events.page.FrameNavigated
import ai.platon.cdt.kt.serialization.protocol.types.console.ConsoleMessage
import ai.platon.cdt.kt.serialization.protocol.types.console.ConsoleMessageLevel
import ai.platon.cdt.kt.serialization.protocol.types.console.ConsoleMessageSource
import ai.platon.cdt.kt.serialization.protocol.types.dom.BoxModel
import ai.platon.cdt.kt.serialization.protocol.types.dom.CSSComputedStyleProperty
import ai.platon.cdt.kt.serialization.protocol.types.dom.Node
import ai.platon.cdt.kt.serialization.protocol.types.dom.PerformSearch
import ai.platon.cdt.kt.serialization.protocol.types.dom.Rect
import ai.platon.cdt.kt.serialization.protocol.types.fetch.AuthChallengeResponse
import ai.platon.cdt.kt.serialization.protocol.types.fetch.AuthChallengeResponseResponse
import ai.platon.cdt.kt.serialization.protocol.types.fetch.HeaderEntry
import ai.platon.cdt.kt.serialization.protocol.types.fetch.RequestPattern
import ai.platon.cdt.kt.serialization.protocol.types.input.DispatchDragEventType
import ai.platon.cdt.kt.serialization.protocol.types.input.DispatchKeyEventType
import ai.platon.cdt.kt.serialization.protocol.types.input.DragData
import ai.platon.cdt.kt.serialization.protocol.types.input.DragDataItem
import ai.platon.cdt.kt.serialization.protocol.types.network.Cookie
import ai.platon.cdt.kt.serialization.protocol.types.network.CookiePriority
import ai.platon.cdt.kt.serialization.protocol.types.network.CookieSourceScheme
import ai.platon.cdt.kt.serialization.protocol.types.network.ErrorReason
import ai.platon.cdt.kt.serialization.protocol.types.network.ErrorReason.BLOCKED_BY_RESPONSE
import ai.platon.cdt.kt.serialization.protocol.types.network.LoadNetworkResourceOptions
import ai.platon.cdt.kt.serialization.protocol.types.network.LoadNetworkResourcePageResult
import ai.platon.cdt.kt.serialization.protocol.types.page.CaptureScreenshotFormat
import ai.platon.cdt.kt.serialization.protocol.types.page.Frame
import ai.platon.cdt.kt.serialization.protocol.types.page.FrameTree
import ai.platon.cdt.kt.serialization.protocol.types.page.LayoutMetrics
import ai.platon.cdt.kt.serialization.protocol.types.page.Navigate
import ai.platon.cdt.kt.serialization.protocol.types.page.ReferrerPolicy
import ai.platon.cdt.kt.serialization.protocol.types.page.TransitionType
import ai.platon.cdt.kt.serialization.protocol.types.page.Viewport
import ai.platon.cdt.kt.serialization.protocol.types.runtime.CallArgument
import ai.platon.cdt.kt.serialization.protocol.types.runtime.CallFunctionOn
import ai.platon.cdt.kt.serialization.protocol.types.runtime.Evaluate
import ai.platon.cdt.kt.serialization.protocol.types.runtime.RemoteObject
import ai.platon.cdt.kt.serialization.protocol.types.runtime.RemoteObjectType
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import kotlin.test.assertTrue

class DirectChromeProtocolTest {

    private lateinit var mock: MockRemoteDevTools
    private lateinit var protocol: DirectChromeProtocol

    @BeforeEach
    fun setUp() {
        mock = MockRemoteDevTools()
        protocol = DirectChromeProtocol(mock)
    }

    @AfterEach
    fun tearDown() {
        mock.reset()
    }

    // ---- Helpers ----

    private fun lastInvocation() = mock.invocations.last()
    private fun lastMethod() = lastInvocation().method
    private fun lastParams() = lastInvocation().params

    // Reusable test fixtures
    private val testFrame = Frame(
        id = "frame-1",
        loaderId = "loader-1",
        url = "https://example.com",
        domainAndRegistry = "example.com",
        securityOrigin = "https://example.com",
        mimeType = "text/html",
        secureContextType = ai.platon.cdt.kt.serialization.protocol.types.page.SecureContextType.SECURE,
        crossOriginIsolatedContextType = ai.platon.cdt.kt.serialization.protocol.types.page.CrossOriginIsolatedContextType.NOT_ISOLATED,
        gatedAPIFeatures = emptyList(),
    )

    // ========================================================================
    // Health checks
    // ========================================================================

    @Test
    fun `isBrowserAlive sends Browser getVersion`() = runTest {
        mock.respond("Browser.getVersion") { true }
        val result = protocol.isBrowserAlive()
        assertTrue(result)
        assertEquals("Browser.getVersion", lastMethod())
    }

    @Test
    fun `isBrowserAlive returns false on exception`() = runTest {
        mock.respond("Browser.getVersion") { throw RuntimeException("boom") }
        val result = protocol.isBrowserAlive()
        assertEquals(false, result)
    }

    @Test
    fun `isTargetAlive sends Target getTargets`() = runTest {
        mock.respond("Target.getTargets") { true }
        val result = protocol.isTargetAlive()
        assertTrue(result)
        assertEquals("Target.getTargets", lastMethod())
    }

    @Test
    fun `isV8Alive sends Runtime evaluate`() = runTest {
        mock.respond("Runtime.evaluate") { true }
        val result = protocol.isV8Alive()
        assertTrue(result)
        assertEquals("Runtime.evaluate", lastMethod())
        assertEquals("1+1", lastParams()?.get("expression"))
    }

    // ========================================================================
    // Enable methods
    // ========================================================================

    @Test
    fun `pageEnable sends Page enable`() = runTest {
        mock.respond("Page.enable") { Unit }
        protocol.pageEnable()
        assertEquals("Page.enable", lastMethod())
    }

    @Test
    fun `domEnable sends DOM enable`() = runTest {
        mock.respond("DOM.enable") { Unit }
        protocol.domEnable()
        assertEquals("DOM.enable", lastMethod())
    }

    @Test
    fun `accessibilityEnable sends Accessibility enable`() = runTest {
        mock.respond("Accessibility.enable") { Unit }
        protocol.accessibilityEnable()
        assertEquals("Accessibility.enable", lastMethod())
    }

    @Test
    fun `runtimeEnable sends Runtime enable`() = runTest {
        mock.respond("Runtime.enable") { Unit }
        protocol.runtimeEnable()
        assertEquals("Runtime.enable", lastMethod())
    }

    @Test
    fun `networkEnable sends Network enable`() = runTest {
        mock.respond("Network.enable") { Unit }
        protocol.networkEnable()
        assertEquals("Network.enable", lastMethod())
    }

    @Test
    fun `cssEnable sends CSS enable`() = runTest {
        mock.respond("CSS.enable") { Unit }
        protocol.cssEnable()
        assertEquals("CSS.enable", lastMethod())
    }

    @Test
    fun `fetchEnable sends Fetch enable`() = runTest {
        mock.respond("Fetch.enable") { Unit }
        protocol.fetchEnable()
        assertEquals("Fetch.enable", lastMethod())
    }

    @Test
    fun `fetchEnable with patterns sends correct params`() = runTest {
        mock.respond("Fetch.enable") { Unit }
        val patterns = listOf(
            RequestPattern(urlPattern = "*.js", resourceType = null, requestStage = null),
        )
        protocol.fetchEnable(patterns, handleAuthRequests = true)

        assertEquals("Fetch.enable", lastMethod())
        val params = lastParams()!!
        assertEquals(patterns, params["patterns"])
        assertEquals(true, params["handleAuthRequests"])
    }

    @Test
    fun `securityEnable sends Security enable`() = runTest {
        mock.respond("Security.enable") { Unit }
        protocol.securityEnable()
        assertEquals("Security.enable", lastMethod())
    }

    // ========================================================================
    // Page domain
    // ========================================================================

    @Test
    fun `mainFrame returns frame from getFrameTree`() = runTest {
        val frameTree = FrameTree(frame = testFrame, childFrames = null)
        mock.respond("Page.getFrameTree") { frameTree }

        val result = protocol.mainFrame()
        assertEquals("frame-1", result.id)
        assertEquals("https://example.com", result.url)
        assertEquals("Page.getFrameTree", lastMethod())
    }

    @Test
    fun `getFrameTree returns full frame tree`() = runTest {
        val frameTree = FrameTree(frame = testFrame, childFrames = null)
        mock.respond("Page.getFrameTree") { frameTree }

        val result = protocol.getFrameTree()
        assertEquals(testFrame.id, result.frame.id)
    }

    @Test
    fun `reload sends Page reload`() = runTest {
        mock.respond("Page.reload") { Unit }
        protocol.reload()
        assertEquals("Page.reload", lastMethod())
    }

    @Test
    fun `navigateToHistoryEntry sends correct params`() = runTest {
        mock.respond("Page.navigateToHistoryEntry") { Unit }
        protocol.navigateToHistoryEntry(42)
        assertEquals("Page.navigateToHistoryEntry", lastMethod())
        assertEquals(42, lastParams()?.get("entryId"))
    }

    @Test
    fun `handleJavaScriptDialog sends correct params`() = runTest {
        mock.respond("Page.handleJavaScriptDialog") { Unit }
        protocol.handleJavaScriptDialog(accept = true, promptText = "hello")
        assertEquals("Page.handleJavaScriptDialog", lastMethod())
        assertEquals(true, lastParams()?.get("accept"))
        assertEquals("hello", lastParams()?.get("promptText"))
    }

    @Test
    fun `handleJavaScriptDialog without promptText omits null`() = runTest {
        mock.respond("Page.handleJavaScriptDialog") { Unit }
        protocol.handleJavaScriptDialog(accept = false)
        assertEquals(false, lastParams()?.get("accept"))
        assertNull(lastParams()?.get("promptText"))
    }

    @Test
    fun `bringToFront sends Page bringToFront`() = runTest {
        mock.respond("Page.bringToFront") { Unit }
        protocol.bringToFront()
        assertEquals("Page.bringToFront", lastMethod())
    }

    @Test
    fun `stopLoading sends Page stopLoading`() = runTest {
        mock.respond("Page.stopLoading") { Unit }
        protocol.stopLoading()
        assertEquals("Page.stopLoading", lastMethod())
    }

    @Test
    fun `addScriptToEvaluateOnNewDocument sends source param and returns identifier`() = runTest {
        mock.respond("Page.addScriptToEvaluateOnNewDocument") { "script-id-1" }
        val result = protocol.addScriptToEvaluateOnNewDocument("console.log(1)")
        assertEquals("script-id-1", result)
        assertEquals("Page.addScriptToEvaluateOnNewDocument", lastMethod())
        assertEquals("console.log(1)", lastParams()?.get("source"))
    }

    @Test
    fun `navigate simple sends url`() = runTest {
        val navigate = Navigate(frameId = "f1", loaderId = "l1")
        mock.respond("Page.navigate") { navigate }

        val result = protocol.navigate("https://example.com")
        assertEquals("f1", result.frameId)
        assertEquals("https://example.com", lastParams()?.get("url"))
    }

    @Test
    fun `navigate with all params sends full map`() = runTest {
        val navigate = Navigate(frameId = "f1", loaderId = "l1")
        mock.respond("Page.navigate") { navigate }

        val result = protocol.navigate(
            url = "https://example.com",
            referrer = "https://referrer.com",
            transitionType = TransitionType.TYPED,
            frameId = "frame-1",
            referrerPolicy = ReferrerPolicy.STRICT_ORIGIN_WHEN_CROSS_ORIGIN,
        )
        assertEquals("f1", result.frameId)
        val params = lastParams()!!
        assertEquals("https://example.com", params["url"])
        assertEquals("https://referrer.com", params["referrer"])
        assertEquals(TransitionType.TYPED, params["transitionType"])
        assertEquals("frame-1", params["frameId"])
        assertEquals(ReferrerPolicy.STRICT_ORIGIN_WHEN_CROSS_ORIGIN, params["referrerPolicy"])
    }

    @Test
    fun `reloadPage with options sends params`() = runTest {
        mock.respond("Page.reload") { Unit }
        protocol.reloadPage(ignoreCache = true, scriptToEvaluateOnLoad = "1+1")
        assertEquals("Page.reload", lastMethod())
        assertEquals(true, lastParams()?.get("ignoreCache"))
        assertEquals("1+1", lastParams()?.get("scriptToEvaluateOnLoad"))
    }

    // ========================================================================
    // Page domain — continued
    // ========================================================================

    @Test
    fun `getLayoutMetrics returns LayoutMetrics`() = runTest {
        val metrics = LayoutMetrics(
            layoutViewport = ai.platon.cdt.kt.serialization.protocol.types.page.LayoutViewport(0, 0, 1024, 768),
            visualViewport = ai.platon.cdt.kt.serialization.protocol.types.page.VisualViewport(0.0, 0.0, 0.0, 0.0, 1024.0, 768.0, 1.0),
            contentSize = Rect(0.0, 0.0, 1024.0, 768.0),
            cssLayoutViewport = ai.platon.cdt.kt.serialization.protocol.types.page.LayoutViewport(0, 0, 1024, 768),
            cssVisualViewport = ai.platon.cdt.kt.serialization.protocol.types.page.VisualViewport(0.0, 0.0, 0.0, 0.0, 1024.0, 768.0, 1.0),
            cssContentSize = Rect(0.0, 0.0, 1024.0, 768.0),
        )
        mock.respond("Page.getLayoutMetrics") { metrics }

        val result = protocol.getLayoutMetrics()
        assertEquals(1024, result.cssLayoutViewport.clientWidth)
        assertEquals("Page.getLayoutMetrics", lastMethod())
    }

    @Test
    fun `captureScreenshot sends format and returns base64 data`() = runTest {
        mock.respond("Page.captureScreenshot") { "base64encoded" }
        val result = protocol.captureScreenshot(format = CaptureScreenshotFormat.PNG, quality = 80)
        assertEquals("base64encoded", result)
        assertEquals("Page.captureScreenshot", lastMethod())
        assertEquals(CaptureScreenshotFormat.PNG, lastParams()?.get("format"))
        assertEquals(80, lastParams()?.get("quality"))
    }

    @Test
    fun `createIsolatedWorld returns executionContextId`() = runTest {
        mock.respond("Page.createIsolatedWorld") { 12345 }
        val result = protocol.createIsolatedWorld("frame-1", "test-world", grantUniveralAccess = true)
        assertEquals(12345, result)
        assertEquals("Page.createIsolatedWorld", lastMethod())
        assertEquals("frame-1", lastParams()?.get("frameId"))
        assertEquals("test-world", lastParams()?.get("worldName"))
    }

    // ========================================================================
    // Emulation domain
    // ========================================================================

    @Test
    fun `setDeviceMetricsOverride sends all params`() = runTest {
        mock.respond("Emulation.setDeviceMetricsOverride") { Unit }
        protocol.setDeviceMetricsOverride(
            mobile = true,
            width = 375,
            height = 812,
            deviceScaleFactor = 2.0,
            screenWidth = 750,
            screenHeight = 1334,
        )
        assertEquals("Emulation.setDeviceMetricsOverride", lastMethod())
        val params = lastParams()!!
        assertEquals(true, params["mobile"])
        assertEquals(375, params["width"])
        assertEquals(812, params["height"])
        assertEquals(2.0, params["deviceScaleFactor"])
        assertEquals(750, params["screenWidth"])
        assertEquals(1334, params["screenHeight"])
    }

    @Test
    fun `clearDeviceMetricsOverride sends correct command`() = runTest {
        mock.respond("Emulation.clearDeviceMetricsOverride") { Unit }
        protocol.clearDeviceMetricsOverride()
        assertEquals("Emulation.clearDeviceMetricsOverride", lastMethod())
    }

    // ========================================================================
    // Runtime domain
    // ========================================================================

    @Test
    fun `evaluate simple expression`() = runTest {
        val remoteObj = RemoteObject(type = RemoteObjectType.STRING, value = kotlinx.serialization.json.JsonPrimitive("hello"))
        val evaluate = Evaluate(result = remoteObj)
        mock.respond("Runtime.evaluate") { evaluate }

        val result = protocol.evaluate("'hello'")
        assertEquals(RemoteObjectType.STRING, result.result.type)
        assertEquals("Runtime.evaluate", lastMethod())
        assertEquals("'hello'", lastParams()?.get("expression"))
    }

    @Test
    fun `evaluate with all optional params`() = runTest {
        val remoteObj = RemoteObject(type = RemoteObjectType.NUMBER, value = kotlinx.serialization.json.JsonPrimitive(42))
        val evaluate = Evaluate(result = remoteObj)
        mock.respond("Runtime.evaluate") { evaluate }

        val result = protocol.evaluate(
            expression = "1+1",
            contextId = 1,
            returnByValue = true,
            awaitPromise = false,
        )
        assertEquals(RemoteObjectType.NUMBER, result.result.type)
        val params = lastParams()!!
        assertEquals("1+1", params["expression"])
        assertEquals(1, params["contextId"])
        assertEquals(true, params["returnByValue"])
        assertEquals(false, params["awaitPromise"])
    }

    @Test
    fun `callFunctionOn sends all params`() = runTest {
        val remoteObj = RemoteObject(type = RemoteObjectType.OBJECT, objectId = "obj-1")
        val callResult = CallFunctionOn(result = remoteObj)
        mock.respond("Runtime.callFunctionOn") { callResult }

        val arguments = listOf(CallArgument(value = kotlinx.serialization.json.JsonPrimitive("arg1")))
        val result = protocol.callFunctionOn(
            functionDeclaration = "function(a) { return a; }",
            objectId = "obj-1",
            arguments = arguments,
            returnByValue = true,
            awaitPromise = true,
        )
        assertEquals("obj-1", result.result.objectId)
        assertEquals("Runtime.callFunctionOn", lastMethod())
        val params = lastParams()!!
        assertEquals("function(a) { return a; }", params["functionDeclaration"])
        assertEquals("obj-1", params["objectId"])
        assertEquals(arguments, params["arguments"])
        assertEquals(true, params["returnByValue"])
        assertEquals(true, params["awaitPromise"])
    }

    @Test
    fun `releaseObject sends objectId`() = runTest {
        mock.respond("Runtime.releaseObject") { Unit }
        protocol.releaseObject("obj-123")
        assertEquals("Runtime.releaseObject", lastMethod())
        assertEquals("obj-123", lastParams()?.get("objectId"))
    }

    // ========================================================================
    // DOM domain
    // ========================================================================

    @Test
    fun `getDocument returns root node`() = runTest {
        val node = Node(
            nodeId = 1, backendNodeId = 100, nodeType = 9,
            nodeName = "#document", localName = "", nodeValue = "",
        )
        mock.respond("DOM.getDocument") { node }

        val result = protocol.getDocument(depth = 2, pierce = true)
        assertEquals(1, result.nodeId)
        assertEquals("#document", result.nodeName)
        assertEquals("DOM.getDocument", lastMethod())
        assertEquals(2, lastParams()?.get("depth"))
        assertEquals(true, lastParams()?.get("pierce"))
    }

    @Test
    fun `getBoxModel returns BoxModel`() = runTest {
        val boxModel = BoxModel(
            content = listOf(0.0, 0.0, 100.0, 100.0),
            padding = listOf(10.0, 10.0, 110.0, 110.0),
            border = listOf(10.0, 10.0, 110.0, 110.0),
            margin = listOf(20.0, 20.0, 120.0, 120.0),
            width = 100,
            height = 100,
        )
        mock.respond("DOM.getBoxModel") { boxModel }

        val result = protocol.getBoxModel(nodeId = 5)
        assertEquals(100, result.width)
        assertEquals(100, result.height)
        assertEquals("DOM.getBoxModel", lastMethod())
        assertEquals(5, lastParams()?.get("nodeId"))
    }

    @Test
    fun `querySelector returns nodeId`() = runTest {
        mock.respond("DOM.querySelector") { 42 }
        val result = protocol.querySelector(nodeId = 1, selector = ".my-class")
        assertEquals(42, result)
        assertEquals("DOM.querySelector", lastMethod())
        assertEquals(1, lastParams()?.get("nodeId"))
        assertEquals(".my-class", lastParams()?.get("selector"))
    }

    @Test
    fun `querySelectorAll returns list of nodeIds`() = runTest {
        mock.respondList("DOM.querySelectorAll") { listOf(1, 2, 3) }
        val result = protocol.querySelectorAll(nodeId = 1, selector = "div")
        assertEquals(listOf(1, 2, 3), result)
        assertEquals("DOM.querySelectorAll", lastMethod())
    }

    @Test
    fun `getContentQuads returns nested list`() = runTest {
        mock.respondNestedList("DOM.getContentQuads") {
            listOf(listOf(0.0, 0.0, 100.0, 0.0, 100.0, 100.0, 0.0, 100.0))
        }
        val result = protocol.getContentQuads(nodeId = 5)
        assertEquals(1, result.size)
        assertEquals(8, result[0].size)
        assertEquals("DOM.getContentQuads", lastMethod())
    }

    @Test
    fun `performSearch sends query`() = runTest {
        val searchResult = PerformSearch(searchId = "search-1", resultCount = 5)
        mock.respond("DOM.performSearch") { searchResult }

        val result = protocol.performSearch("//div")
        assertEquals("search-1", result.searchId)
        assertEquals(5, result.resultCount)
        assertEquals("DOM.performSearch", lastMethod())
        assertEquals("//div", lastParams()?.get("query"))
    }

    @Test
    fun `getSearchResults returns nodeIds`() = runTest {
        mock.respondList("DOM.getSearchResults") { listOf(10, 20, 30) }

        val result = protocol.getSearchResults("search-1", 0, 3)
        assertEquals(listOf(10, 20, 30), result)
        assertEquals("DOM.getSearchResults", lastMethod())
        assertEquals("search-1", lastParams()?.get("searchId"))
        assertEquals(0, lastParams()?.get("fromIndex"))
        assertEquals(3, lastParams()?.get("toIndex"))
    }

    @Test
    fun `discardSearchResults sends searchId`() = runTest {
        mock.respond("DOM.discardSearchResults") { Unit }
        protocol.discardSearchResults("search-1")
        assertEquals("DOM.discardSearchResults", lastMethod())
        assertEquals("search-1", lastParams()?.get("searchId"))
    }

    @Test
    fun `getAttributes returns list`() = runTest {
        mock.respondList("DOM.getAttributes") { listOf("class", "my-class", "id", "my-id") }
        val result = protocol.getAttributes(nodeId = 5)
        assertEquals(listOf("class", "my-class", "id", "my-id"), result)
        assertEquals("DOM.getAttributes", lastMethod())
    }

    @Test
    fun `focus sends nodeId`() = runTest {
        mock.respond("DOM.focus") { Unit }
        protocol.focus(nodeId = 10)
        assertEquals("DOM.focus", lastMethod())
        assertEquals(10, lastParams()?.get("nodeId"))
    }

    @Test
    fun `describeNode returns Node`() = runTest {
        val node = Node(
            nodeId = 5, backendNodeId = 500, nodeType = 1,
            nodeName = "DIV", localName = "div", nodeValue = "",
        )
        mock.respond("DOM.describeNode") { node }

        val result = protocol.describeNode(nodeId = 5, depth = 1)
        assertEquals("DIV", result.nodeName)
        assertEquals(5, result.nodeId)
        assertEquals("DOM.describeNode", lastMethod())
        assertEquals(5, lastParams()?.get("nodeId"))
        assertEquals(1, lastParams()?.get("depth"))
    }

    @Test
    fun `scrollIntoViewIfNeeded sends params`() = runTest {
        mock.respond("DOM.scrollIntoViewIfNeeded") { Unit }
        protocol.scrollIntoViewIfNeeded(nodeId = 5, rect = Rect(0.0, 0.0, 100.0, 100.0))
        assertEquals("DOM.scrollIntoViewIfNeeded", lastMethod())
        assertEquals(5, lastParams()?.get("nodeId"))
    }

    @Test
    fun `resolveNodeByNodeId returns RemoteObject`() = runTest {
        val remoteObj = RemoteObject(type = RemoteObjectType.OBJECT, objectId = "obj-123")
        mock.respond("DOM.resolveNode") { remoteObj }

        val result = protocol.resolveNodeByNodeId(5)
        assertEquals("obj-123", result.objectId)
        assertEquals("DOM.resolveNode", lastMethod())
        assertEquals(5, lastParams()?.get("nodeId"))
    }

    @Test
    fun `resolveNodeByBackendNodeId returns RemoteObject`() = runTest {
        val remoteObj = RemoteObject(type = RemoteObjectType.OBJECT, objectId = "obj-456")
        mock.respond("DOM.resolveNode") { remoteObj }

        val result = protocol.resolveNodeByBackendNodeId(100)
        assertEquals("obj-456", result.objectId)
        assertEquals("DOM.resolveNode", lastMethod())
        assertEquals(100, lastParams()?.get("backendNodeId"))
    }

    @Test
    fun `requestNode returns nodeId`() = runTest {
        mock.respond("DOM.requestNode") { 99 }
        val result = protocol.requestNode("obj-123")
        assertEquals(99, result)
        assertEquals("DOM.requestNode", lastMethod())
        assertEquals("obj-123", lastParams()?.get("objectId"))
    }

    @Test
    fun `getOuterHTML returns HTML string`() = runTest {
        mock.respond("DOM.getOuterHTML") { "<div>hello</div>" }
        val result = protocol.getOuterHTML(nodeId = 5, backendNodeId = 500)
        assertEquals("<div>hello</div>", result)
        assertEquals("DOM.getOuterHTML", lastMethod())
        assertEquals(5, lastParams()?.get("nodeId"))
        assertEquals(500, lastParams()?.get("backendNodeId"))
    }

    // ========================================================================
    // CSS domain
    // ========================================================================

    @Test
    fun `getComputedStyleForNode returns computed styles`() = runTest {
        val styles = listOf(
            CSSComputedStyleProperty(name = "color", `value` = "rgb(0, 0, 0)"),
            CSSComputedStyleProperty(name = "font-size", `value` = "16px"),
        )
        mock.respondList("CSS.getComputedStyleForNode") { styles }

        val result = protocol.getComputedStyleForNode(nodeId = 5)
        assertEquals(2, result.size)
        assertEquals("color", result[0].name)
        assertEquals("CSS.getComputedStyleForNode", lastMethod())
        assertEquals(5, lastParams()?.get("nodeId"))
    }

    // ========================================================================
    // Network domain
    // ========================================================================

    @Test
    fun `clearBrowserCookies sends Network clearBrowserCookies`() = runTest {
        mock.respond("Network.clearBrowserCookies") { Unit }
        protocol.clearBrowserCookies()
        assertEquals("Network.clearBrowserCookies", lastMethod())
    }

    @Test
    fun `setBlockedURLs sends urls`() = runTest {
        mock.respond("Network.setBlockedURLs") { Unit }
        protocol.setBlockedURLs(listOf("https://ads.example.com", "*.tracker.com"))
        assertEquals("Network.setBlockedURLs", lastMethod())
        assertEquals(listOf("https://ads.example.com", "*.tracker.com"), lastParams()?.get("urls"))
    }

    @Test
    fun `getCookies returns cookie list`() = runTest {
        val cookies = listOf(
            Cookie(
                name = "session", `value` = "abc123", domain = "example.com",
                path = "/", expires = 9999999.0, size = 10, httpOnly = false, secure = true,
                session = false, sameSite = null, priority = CookiePriority.MEDIUM,
                sourceScheme = CookieSourceScheme.SECURE, sourcePort = 443,
            )
        )
        mock.respondList("Network.getCookies") { cookies }

        val result = protocol.getCookies()
        assertEquals(1, result.size)
        assertEquals("session", result[0].name)
        assertEquals("Network.getCookies", lastMethod())
    }

    @Test
    fun `deleteCookies sends params`() = runTest {
        mock.respond("Network.deleteCookies") { Unit }
        protocol.deleteCookies(
            name = "session", url = "https://example.com",
            domain = "example.com", path = "/",
        )
        assertEquals("Network.deleteCookies", lastMethod())
        val params = lastParams()!!
        assertEquals("session", params["name"])
        assertEquals("https://example.com", params["url"])
        assertEquals("example.com", params["domain"])
        assertEquals("/", params["path"])
    }

    @Test
    fun `loadNetworkResource sends frameId url and options`() = runTest {
        val result = LoadNetworkResourcePageResult(
            success = true,
            netError = null,
            netErrorName = null,
            httpStatusCode = null,
            stream = null,
            headers = null,
        )
        mock.respond("Network.loadNetworkResource") { result }

        val options = LoadNetworkResourceOptions(disableCache = true, includeCredentials = false)
        val response = protocol.loadNetworkResource("frame-1", "https://example.com", options)
        assertTrue(response.success)
        assertEquals("Network.loadNetworkResource", lastMethod())
        assertEquals("frame-1", lastParams()?.get("frameId"))
        assertEquals("https://example.com", lastParams()?.get("url"))
    }

    @Test
    fun `setExtraHTTPHeaders sends headers`() = runTest {
        mock.respond("Network.setExtraHTTPHeaders") { Unit }
        val headers = mapOf<String, Any>("X-Custom" to "value1", "Authorization" to "Bearer token")
        protocol.setExtraHTTPHeaders(headers)
        assertEquals("Network.setExtraHTTPHeaders", lastMethod())
        assertEquals(headers, lastParams()?.get("headers"))
    }

    @Test
    fun `setCacheDisabled sends flag`() = runTest {
        mock.respond("Network.setCacheDisabled") { Unit }
        protocol.setCacheDisabled(true)
        assertEquals("Network.setCacheDisabled", lastMethod())
        assertEquals(true, lastParams()?.get("cacheDisabled"))
    }

    @Test
    fun `setCookies sends cookies list of maps`() = runTest {
        mock.respond("Network.setCookies") { Unit }
        val cookies = listOf(
            mapOf<String, Any?>("name" to "session", "value" to "abc", "domain" to "example.com"),
        )
        protocol.setCookies(cookies)
        assertEquals("Network.setCookies", lastMethod())
        assertEquals(cookies, lastParams()?.get("cookies"))
    }

    // ========================================================================
    // Fetch domain
    // ========================================================================

    @Test
    fun `failRequest sends requestId and errorReason`() = runTest {
        mock.respond("Fetch.failRequest") { Unit }
        protocol.failRequest("req-1", BLOCKED_BY_RESPONSE)
        assertEquals("Fetch.failRequest", lastMethod())
        assertEquals("req-1", lastParams()?.get("requestId"))
        assertEquals(BLOCKED_BY_RESPONSE, lastParams()?.get("errorReason"))
    }

    @Test
    fun `continueRequest sends all params`() = runTest {
        mock.respond("Fetch.continueRequest") { Unit }
        val headers = listOf(HeaderEntry(name = "X-Custom", `value` = "v1"))
        protocol.continueRequest(
            requestId = "req-1", url = "https://new-url.com",
            method = "POST", postData = "body", headers = headers,
        )
        assertEquals("Fetch.continueRequest", lastMethod())
        val params = lastParams()!!
        assertEquals("req-1", params["requestId"])
        assertEquals("https://new-url.com", params["url"])
        assertEquals("POST", params["method"])
        assertEquals("body", params["postData"])
        assertEquals(headers, params["headers"])
    }

    @Test
    fun `continueWithAuth sends params`() = runTest {
        mock.respond("Fetch.continueWithAuth") { Unit }
        val authResponse = AuthChallengeResponse(
            response = AuthChallengeResponseResponse.PROVIDE_CREDENTIALS,
            username = "user",
            password = "pass",
        )
        protocol.continueWithAuth("req-1", authResponse)
        assertEquals("Fetch.continueWithAuth", lastMethod())
        assertEquals("req-1", lastParams()?.get("requestId"))
        assertEquals(authResponse, lastParams()?.get("authChallengeResponse"))
    }

    @Test
    fun `fulfillRequest sends all params`() = runTest {
        mock.respond("Fetch.fulfillRequest") { Unit }
        val headers = listOf(HeaderEntry(name = "Content-Type", `value` = "text/html"))
        protocol.fulfillRequest(
            requestId = "req-1", responseCode = 200,
            responseHeaders = headers, body = "<html></html>",
            responsePhrase = "OK",
        )
        assertEquals("Fetch.fulfillRequest", lastMethod())
        val params = lastParams()!!
        assertEquals("req-1", params["requestId"])
        assertEquals(200, params["responseCode"])
        assertEquals(headers, params["responseHeaders"])
        assertEquals("<html></html>", params["body"])
        assertEquals("OK", params["responsePhrase"])
    }

    @Test
    fun `getResponseBody returns ResponseBody`() = runTest {
        val responseBody = ai.platon.cdt.kt.serialization.protocol.types.fetch.ResponseBody(
            body = "response content", base64Encoded = false
        )
        mock.respond("Fetch.getResponseBody") { responseBody }

        val result = protocol.getResponseBody("req-1")
        assertEquals("response content", result.body)
        assertEquals("Fetch.getResponseBody", lastMethod())
        assertEquals("req-1", lastParams()?.get("requestId"))
    }

    // ========================================================================
    // Input domain — mouse
    // ========================================================================

    @Test
    fun `dispatchMouseMoved sends type and coords`() = runTest {
        mock.respond("Input.dispatchMouseEvent") { Unit }
        protocol.dispatchMouseMoved(x = 100.0, y = 200.0, buttons = 0)
        assertEquals("Input.dispatchMouseEvent", lastMethod())
        val params = lastParams()!!
        assertEquals(ai.platon.cdt.kt.serialization.protocol.types.input.DispatchMouseEventType.MOUSE_MOVED, params["type"])
        assertEquals(100.0, params["x"])
        assertEquals(200.0, params["y"])
    }

    @Test
    fun `dispatchMousePressed sends left button`() = runTest {
        mock.respond("Input.dispatchMouseEvent") { Unit }
        protocol.dispatchMousePressed(x = 50.0, y = 60.0, clickCount = 1, modifiers = null, buttons = 1)
        assertEquals("Input.dispatchMouseEvent", lastMethod())
        val params = lastParams()!!
        assertEquals(ai.platon.cdt.kt.serialization.protocol.types.input.DispatchMouseEventType.MOUSE_PRESSED, params["type"])
        assertEquals(ai.platon.cdt.kt.serialization.protocol.types.input.MouseButton.LEFT, params["button"])
        assertEquals(1, params["clickCount"])
    }

    @Test
    fun `dispatchMouseReleased sends correct type`() = runTest {
        mock.respond("Input.dispatchMouseEvent") { Unit }
        protocol.dispatchMouseReleased(x = 50.0, y = 60.0, clickCount = 1, modifiers = null, buttons = 1)
        assertEquals("Input.dispatchMouseEvent", lastMethod())
        assertEquals(ai.platon.cdt.kt.serialization.protocol.types.input.DispatchMouseEventType.MOUSE_RELEASED, lastParams()?.get("type"))
    }

    @Test
    fun `dispatchMouseWheel sends delta`() = runTest {
        mock.respond("Input.dispatchMouseEvent") { Unit }
        protocol.dispatchMouseWheel(x = 100.0, y = 200.0, deltaX = 0.0, deltaY = -100.0)
        assertEquals("Input.dispatchMouseEvent", lastMethod())
        val params = lastParams()!!
        assertEquals(-100.0, params["deltaY"])
        assertEquals(0.0, params["deltaX"])
    }

    @Test
    fun `setInterceptDrags sends enabled flag`() = runTest {
        mock.respond("Input.setInterceptDrags") { Unit }
        protocol.setInterceptDrags(true)
        assertEquals("Input.setInterceptDrags", lastMethod())
        assertEquals(true, lastParams()?.get("enabled"))
    }

    @Test
    fun `dispatchDragEvent sends type and data`() = runTest {
        mock.respond("Input.dispatchDragEvent") { Unit }
        val dragData = DragData(items = emptyList(), dragOperationsMask = 1)
        protocol.dispatchDragEvent(
            type = DispatchDragEventType.DRAG_ENTER,
            x = 100.0, y = 200.0, data = dragData,
        )
        assertEquals("Input.dispatchDragEvent", lastMethod())
        assertEquals(DispatchDragEventType.DRAG_ENTER, lastParams()?.get("type"))
    }

    @Test
    fun `insertText sends text`() = runTest {
        mock.respond("Input.insertText") { Unit }
        protocol.insertText("hello world")
        assertEquals("Input.insertText", lastMethod())
        assertEquals("hello world", lastParams()?.get("text"))
    }

    // ========================================================================
    // Input domain — keyboard
    // ========================================================================

    @Test
    fun `dispatchKeyEvent sends all params`() = runTest {
        mock.respond("Input.dispatchKeyEvent") { Unit }
        protocol.dispatchKeyEvent(
            type = DispatchKeyEventType.KEY_DOWN,
            key = "Enter",
            code = "Enter",
            windowsVirtualKeyCode = 13,
        )
        assertEquals("Input.dispatchKeyEvent", lastMethod())
        val params = lastParams()!!
        assertEquals(DispatchKeyEventType.KEY_DOWN, params["type"])
        assertEquals("Enter", params["key"])
        assertEquals("Enter", params["code"])
        assertEquals(13, params["windowsVirtualKeyCode"])
    }

    // ========================================================================
    // Security domain
    // ========================================================================

    @Test
    fun `setIgnoreCertificateErrors sends ignore flag`() = runTest {
        mock.respond("Security.setIgnoreCertificateErrors") { Unit }
        protocol.setIgnoreCertificateErrors(true)
        assertEquals("Security.setIgnoreCertificateErrors", lastMethod())
        assertEquals(true, lastParams()?.get("ignore"))
    }

    // ========================================================================
    // setFileInputFiles
    // ========================================================================

    @Test
    fun `setFileInputFiles sends files and nodeId`() = runTest {
        mock.respond("DOM.setFileInputFiles") { Unit }
        protocol.setFileInputFiles(listOf("/path/to/file.txt"), nodeId = 5)
        assertEquals("DOM.setFileInputFiles", lastMethod())
        assertEquals(listOf("/path/to/file.txt"), lastParams()?.get("files"))
        assertEquals(5, lastParams()?.get("nodeId"))
    }

    // ========================================================================
    // Event subscriptions
    // ========================================================================

    @Test
    fun `onDocumentOpened registers Page documentOpened listener`() {
        val listener = protocol.onDocumentOpened { }
        assertNotNull(listener)
        assertEquals(1, mock.eventListeners.size)
        val record = mock.eventListeners.first()
        assertEquals("Page", record.domainName)
        assertEquals("documentOpened", record.eventName)
        assertEquals(DocumentOpened::class.java, record.eventType)
    }

    @Test
    fun `onFrameNavigated registers Page frameNavigated listener`() {
        val listener = protocol.onFrameNavigated { }
        assertNotNull(listener)
        assertEquals(1, mock.eventListeners.size)
        val record = mock.eventListeners.first()
        assertEquals("Page", record.domainName)
        assertEquals("frameNavigated", record.eventName)
        assertEquals(FrameNavigated::class.java, record.eventType)
    }

    @Test
    fun `onRequestWillBeSent registers Network requestWillBeSent listener`() {
        val listener = protocol.onRequestWillBeSent { }
        assertNotNull(listener)
        val record = mock.eventListeners.first()
        assertEquals("Network", record.domainName)
        assertEquals("requestWillBeSent", record.eventName)
        assertEquals(RequestWillBeSent::class.java, record.eventType)
    }

    @Test
    fun `onResponseReceived registers Network responseReceived listener`() {
        val listener = protocol.onResponseReceived { }
        assertNotNull(listener)
        val record = mock.eventListeners.first()
        assertEquals("Network", record.domainName)
        assertEquals("responseReceived", record.eventName)
        assertEquals(ResponseReceived::class.java, record.eventType)
    }

    @Test
    fun `onLoadingFinished registers Network loadingFinished listener`() {
        val listener = protocol.onLoadingFinished { }
        assertNotNull(listener)
        val record = mock.eventListeners.first()
        assertEquals("Network", record.domainName)
        assertEquals("loadingFinished", record.eventName)
        assertEquals(LoadingFinished::class.java, record.eventType)
    }

    @Test
    fun `onLoadingFailed registers Network loadingFailed listener`() {
        val listener = protocol.onLoadingFailed { }
        assertNotNull(listener)
        val record = mock.eventListeners.first()
        assertEquals("Network", record.domainName)
        assertEquals("loadingFailed", record.eventName)
        assertEquals(LoadingFailed::class.java, record.eventType)
    }

    @Test
    fun `onRequestServedFromCache registers listener`() {
        val listener = protocol.onRequestServedFromCache { }
        assertNotNull(listener)
        val record = mock.eventListeners.first()
        assertEquals("Network", record.domainName)
        assertEquals("requestServedFromCache", record.eventName)
        assertEquals(RequestServedFromCache::class.java, record.eventType)
    }

    @Test
    fun `onConsoleMessageAdded registers Console messageAdded listener`() {
        val listener = protocol.onConsoleMessageAdded { }
        assertNotNull(listener)
        val record = mock.eventListeners.first()
        assertEquals("Console", record.domainName)
        assertEquals("messageAdded", record.eventName)
        assertEquals(MessageAdded::class.java, record.eventType)
    }

    @Test
    fun `onRequestPaused registers Fetch requestPaused listener`() {
        val listener = protocol.onRequestPaused { }
        assertNotNull(listener)
        val record = mock.eventListeners.first()
        assertEquals("Fetch", record.domainName)
        assertEquals("requestPaused", record.eventName)
    }

    @Test
    fun `onAuthRequired registers Fetch authRequired listener`() {
        val listener = protocol.onAuthRequired { }
        assertNotNull(listener)
        val record = mock.eventListeners.first()
        assertEquals("Fetch", record.domainName)
        assertEquals("authRequired", record.eventName)
    }

    // ========================================================================
    // Event firing — verify handlers are actually called
    // ========================================================================

    @Test
    fun `event handler is called when mock fires event`() = runTest {
        var received: DocumentOpened? = null
        val listener = protocol.onDocumentOpened { received = it }

        val frame = testFrame
        val event = DocumentOpened(frame = frame)
        mock.fireEvent("Page", "documentOpened", event)

        assertNotNull(received)
        assertEquals("frame-1", received.frame.id)
    }

    @Test
    fun `console event handler receives MessageAdded`() = runTest {
        var received: MessageAdded? = null
        val listener = protocol.onConsoleMessageAdded { received = it }

        val consoleMessage = ConsoleMessage(
            source = ConsoleMessageSource.JAVASCRIPT,
            level = ConsoleMessageLevel.ERROR,
            text = "Something went wrong",
        )
        val event = MessageAdded(message = consoleMessage)
        mock.fireEvent("Console", "messageAdded", event)

        assertNotNull(received)
        assertEquals("Something went wrong", received.message.text)
        assertEquals(ConsoleMessageLevel.ERROR, received.message.level)
    }

    // ========================================================================
    // Lifecycle
    // ========================================================================

    @Test
    fun `isOpen delegates to remoteDevTools`() {
        assertEquals(true, protocol.isOpen)
        mock.isOpen = false
        assertEquals(false, protocol.isOpen)
    }

    @Test
    fun `awaitTermination delegates to remoteDevTools`() {
        // Should not throw
        protocol.awaitTermination()
    }

    @Test
    fun `close calls remoteDevTools close`() {
        protocol.close()
        assertEquals(false, mock.isOpen)
    }

    // ========================================================================
    // Companion factory
    // ========================================================================

    @Test
    fun `BrowserProtocol create returns DirectChromeProtocol`() {
        val created = BrowserProtocol.create(mock)
        assertTrue(created is DirectChromeProtocol)
        assertEquals(mock, created.remoteDevToolsOrNull)
    }
}
