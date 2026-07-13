package ai.platon.browser4.chrome.protocol

import org.junit.jupiter.api.Test
import kotlin.test.assertTrue
import kotlin.test.assertFalse

/**
 * Validates every CDP command and event subscription in
 * [DirectChromeProtocol] against the official protocol definitions
 * (`browser_protocol.json` + `js_protocol.json`).
 *
 * This test ensures the hard-coded method strings, parameter names,
 * and return-property names stay in sync with the Chrome DevTools
 * Protocol spec.  It should be run before every release.
 *
 * ## How it works
 *
 * 1. Parse the two protocol JSON files at class-init time.
 * 2. Build lookup maps: domain → command → (param set, return set).
 * 3. For every [CdpCall] declared below, check:
 *    - Domain exists.
 *    - Command exists in that domain.
 *    - Every param name (sans `?` suffix) is known to the spec.
 *    - `returnProperty` (if given) is a known return parameter.
 * 4. For every [CdpEvent], check the domain + event name exist.
 *
 * ## Adding a new CDP call
 *
 * When you add a new `command(...)` call to [DirectChromeProtocol],
 * add the corresponding [CdpCall] entry below so the test stays
 * complete.
 */
class DirectChromeProtocolConformanceTest {

    companion object {
        /** Merged spec from both protocol definition files. */
        private val spec: ProtocolSpec by lazy { parseSpec() }

        /** domain → (commandName → CommandSpec) */
        private val commandsByDomain: Map<String, Map<String, CommandSpec>> by lazy {
            val map = mutableMapOf<String, MutableMap<String, CommandSpec>>()
            for (d in spec.domains) {
                val cmdMap = mutableMapOf<String, CommandSpec>()
                for (c in d.commands) cmdMap[c.name] = c
                map[d.domain] = cmdMap
            }
            map
        }

        /** domain → set of event names */
        private val eventsByDomain: Map<String, Set<String>> by lazy {
            val map = mutableMapOf<String, MutableSet<String>>()
            for (d in spec.domains) {
                val set = mutableSetOf<String>()
                for (e in d.events) set.add(e.name)
                map[d.domain] = set
            }
            map
        }

        private fun parseSpec(): ProtocolSpec {
            val browserProtocol = loadJson("protocol/browser_protocol.json")
            val jsProtocol = loadJson("protocol/js_protocol.json")
            // Merge domains — js_protocol domains (Runtime, Debugger, Console, Schema) are
            // not in browser_protocol.
            val mergedDomains = (browserProtocol.domains + jsProtocol.domains)
                .distinctBy { it.domain }
            return ProtocolSpec(
                version = browserProtocol.version,
                domains = mergedDomains
            )
        }

        private fun loadJson(resourcePath: String): ProtocolSpec {
            val cls = DirectChromeProtocolConformanceTest::class.java
            val bytes = cls.classLoader.getResourceAsStream(resourcePath)?.use { it.readBytes() }
                ?: throw IllegalStateException("Protocol definition not found: $resourcePath")
            return cdpJson.decodeFromString(ProtocolSpec.serializer(), bytes.decodeToString())
        }
    }

    // ────────────────────────────────────────────────────────────────────
    // CDP COMMANDS — every `command(...)` / `listCommand(...)` /
    // `nestedListCommand(...)` call in DirectChromeProtocol
    // ────────────────────────────────────────────────────────────────────

    private val allCommands: List<CdpCall> by lazy {
        listOf(
            // -- Health checks -------------------------------------------------
            CdpCall("Browser.getVersion"),
            CdpCall("Target.getTargets"),
            CdpCall("Runtime.evaluate", params = listOf("expression")),

            // -- Page domain ---------------------------------------------------
            CdpCall("Page.getFrameTree", returnProperty = "frameTree"),
            CdpCall("Page.enable"),
            CdpCall("DOM.enable"),
            CdpCall("Accessibility.enable"),
            CdpCall("Runtime.enable"),
            CdpCall("Network.enable"),
            CdpCall("CSS.enable"),
            CdpCall("Fetch.enable"),
            CdpCall("Fetch.enable", params = listOf("patterns", "handleAuthRequests")),
            CdpCall("Security.enable"),
            CdpCall("Page.reload"),
            CdpCall("Page.reload", params = listOf("ignoreCache?", "scriptToEvaluateOnLoad?")),
            CdpCall("Page.navigateToHistoryEntry", params = listOf("entryId")),
            CdpCall("Page.handleJavaScriptDialog", params = listOf("accept", "promptText?")),
            CdpCall("Page.bringToFront"),
            CdpCall("Page.stopLoading"),
            CdpCall("Page.addScriptToEvaluateOnNewDocument", params = listOf("source"), returnProperty = "identifier"),
            CdpCall("Page.navigate", params = listOf("url", "referrer?", "transitionType?", "frameId?", "referrerPolicy?")),
            CdpCall("Page.getLayoutMetrics"),
            CdpCall("Page.getNavigationHistory"),
            CdpCall("Page.createIsolatedWorld",
                params = listOf("frameId", "worldName", "grantUniveralAccess"), // spec typo preserved
                returnProperty = "executionContextId"),
            CdpCall("Page.captureScreenshot",
                params = listOf("format?", "quality?", "clip?", "fromSurface?", "captureBeyondViewport?"),
                returnProperty = "data"),

            // -- Runtime domain ------------------------------------------------
            CdpCall("Runtime.evaluate",
                params = listOf("expression", "contextId?", "returnByValue?", "awaitPromise?")),
            CdpCall("Runtime.callFunctionOn",
                params = listOf("functionDeclaration", "objectId?", "arguments?", "silent?",
                    "returnByValue?", "generatePreview?", "userGesture?", "awaitPromise?",
                    "executionContextId?", "objectGroup?")),
            CdpCall("Runtime.releaseObject", params = listOf("objectId")),

            // -- Emulation domain ----------------------------------------------
            CdpCall("Emulation.setDeviceMetricsOverride",
                params = listOf("mobile", "width", "height", "deviceScaleFactor", "screenWidth?", "screenHeight?")),
            CdpCall("Emulation.clearDeviceMetricsOverride"),

            // -- DOM domain ----------------------------------------------------
            CdpCall("DOM.getDocument", params = listOf("depth?", "pierce?"), returnProperty = "root"),
            CdpCall("DOM.getContentQuads", params = listOf("nodeId"), returnProperty = "quads"),
            CdpCall("DOM.getBoxModel", params = listOf("nodeId?", "backendNodeId?", "objectId?"), returnProperty = "model"),
            CdpCall("DOM.querySelector", params = listOf("nodeId", "selector"), returnProperty = "nodeId"),
            CdpCall("DOM.querySelectorAll", params = listOf("nodeId", "selector"), returnProperty = "nodeIds"),
            CdpCall("DOM.performSearch", params = listOf("query", "includeUserAgentShadowDOM?")),
            CdpCall("DOM.getSearchResults", params = listOf("searchId", "fromIndex", "toIndex"), returnProperty = "nodeIds"),
            CdpCall("DOM.discardSearchResults", params = listOf("searchId")),
            CdpCall("DOM.getAttributes", params = listOf("nodeId"), returnProperty = "attributes"),
            CdpCall("DOM.focus", params = listOf("nodeId?", "backendNodeId?", "objectId?")),
            CdpCall("DOM.describeNode",
                params = listOf("nodeId?", "backendNodeId?", "objectId?", "depth?", "pierce?"),
                returnProperty = "node"),
            CdpCall("DOM.scrollIntoViewIfNeeded",
                params = listOf("nodeId?", "backendNodeId?", "objectId?", "rect?")),
            CdpCall("DOM.resolveNode",
                params = listOf("nodeId?", "backendNodeId?", "objectGroup?", "executionContextId?"),
                returnProperty = "object"),
            CdpCall("DOM.requestNode", params = listOf("objectId"), returnProperty = "nodeId"),
            CdpCall("DOM.setFileInputFiles", params = listOf("files", "nodeId", "backendNodeId?", "objectId?")),
            CdpCall("DOM.getOuterHTML",
                params = listOf("nodeId?", "backendNodeId?", "objectId?"),
                returnProperty = "outerHTML"),

            // -- CSS domain ----------------------------------------------------
            CdpCall("CSS.getComputedStyleForNode", params = listOf("nodeId"), returnProperty = "computedStyle"),

            // -- Accessibility domain ------------------------------------------
            CdpCall("Accessibility.getFullAXTree", params = listOf("depth?", "frameId?"), returnProperty = "nodes"),

            // -- Network domain ------------------------------------------------
            CdpCall("Network.clearBrowserCookies"),
            CdpCall("Network.setBlockedURLs", params = listOf("urls")),
            CdpCall("Network.getCookies", returnProperty = "cookies"),
            CdpCall("Network.deleteCookies", params = listOf("name", "url?", "domain?", "path?", "partitionKey?")),
            CdpCall("Network.loadNetworkResource",
                params = listOf("frameId?", "url", "options"),
                returnProperty = "resource"),
            CdpCall("Network.setExtraHTTPHeaders", params = listOf("headers")),
            CdpCall("Network.setCacheDisabled", params = listOf("cacheDisabled")),
            CdpCall("Network.setCookies", params = listOf("cookies")),

            // -- Fetch domain --------------------------------------------------
            CdpCall("Fetch.failRequest", params = listOf("requestId", "errorReason")),
            CdpCall("Fetch.getResponseBody", params = listOf("requestId")),
            CdpCall("Fetch.continueRequest",
                params = listOf("requestId", "url?", "method?", "postData?", "headers?",
                    "interceptResponse?")),
            CdpCall("Fetch.continueWithAuth",
                params = listOf("requestId", "authChallengeResponse")),
            CdpCall("Fetch.fulfillRequest",
                params = listOf("requestId", "responseCode", "responseHeaders?",
                    "binaryResponseHeaders?", "body?", "responsePhrase?")),

            // -- Input domain — mouse events -----------------------------------
            CdpCall("Input.dispatchMouseEvent",
                params = listOf("type", "x", "y", "button?", "buttons?", "clickCount?",
                    "force?", "modifiers?", "deltaX?", "deltaY?", "pointerType?", "timestamp?")),
            CdpCall("Input.setInterceptDrags", params = listOf("enabled")),
            CdpCall("Input.dispatchDragEvent", params = listOf("type", "x", "y", "data", "modifiers?")),
            CdpCall("Input.insertText", params = listOf("text")),

            // -- Input domain — keyboard events --------------------------------
            CdpCall("Input.dispatchKeyEvent",
                params = listOf("type", "modifiers?", "windowsVirtualKeyCode?", "code?",
                    "commands?", "key?", "text?", "unmodifiedText?", "location?",
                    "isKeypad?", "autoRepeat?")),

            // -- DOMSnapshot domain --------------------------------------------
            CdpCall("DOMSnapshot.captureSnapshot",
                params = listOf("computedStyles", "includePaintOrder?", "includeDOMRects?",
                    "includeBlendedBackgroundColors?", "includeTextColorOpacities?")),

            // -- Security domain -----------------------------------------------
            CdpCall("Security.setIgnoreCertificateErrors", params = listOf("ignore")),
        )
    }

    // ────────────────────────────────────────────────────────────────────
    // CDP EVENTS — every `onEvent(...)` call in DirectChromeProtocol
    // ────────────────────────────────────────────────────────────────────

    private val allEvents: List<CdpEvent> by lazy {
        listOf(
            CdpEvent("Page", "documentOpened"),
            CdpEvent("Page", "frameNavigated"),
            CdpEvent("Page", "windowOpen"),
            CdpEvent("Network", "requestWillBeSent"),
            CdpEvent("Network", "requestWillBeSentExtraInfo"),
            CdpEvent("Network", "requestServedFromCache"),
            CdpEvent("Network", "responseReceived"),
            CdpEvent("Network", "responseReceivedExtraInfo"),
            CdpEvent("Network", "loadingFinished"),
            CdpEvent("Network", "loadingFailed"),
            CdpEvent("Fetch", "requestPaused"),
            CdpEvent("Fetch", "authRequired"),
            CdpEvent("Input", "dragIntercepted"),
            CdpEvent("Console", "messageAdded"),
        )
    }

    // ────────────────────────────────────────────────────────────────────
    // Tests
    // ────────────────────────────────────────────────────────────────────

    @Test
    fun `all CDP command method names exist in protocol spec`() {
        val failures = mutableListOf<String>()
        for (call in allCommands) {
            val (domain, command) = parseMethod(call.method)
            val domainCommands = commandsByDomain[domain]
            if (domainCommands == null) {
                failures.add("${call.method}: domain '$domain' not found in protocol spec")
                continue
            }
            if (command !in domainCommands) {
                failures.add("${call.method}: command '$command' not found in domain '$domain' " +
                    "(available: ${domainCommands.keys.sorted()})")
            }
        }
        assertTrue(failures.isEmpty(), failures.joinToString("\n", prefix = "\n"))
    }

    @Test
    fun `all CDP command parameter names exist in protocol spec`() {
        val failures = mutableListOf<String>()
        for (call in allCommands) {
            val (domain, command) = parseMethod(call.method)
            val domainCommands = commandsByDomain[domain] ?: continue // reported by method test
            val spec = domainCommands[command] ?: continue // reported by method test

            val specParamNames = spec.parameters.map { it.name }.toSet()

            for (paramWithFlag in call.params) {
                val paramName = paramWithFlag.removeSuffix("?")
                if (paramName !in specParamNames) {
                    failures.add(
                        "${call.method}: param '$paramName' not found in protocol spec " +
                            "(valid params: ${specParamNames.sorted()})"
                    )
                }
            }
        }
        assertTrue(failures.isEmpty(), failures.joinToString("\n", prefix = "\n"))
    }

    @Test
    fun `all CDP command return properties exist in protocol spec`() {
        val failures = mutableListOf<String>()
        for (call in allCommands) {
            val returnProp = call.returnProperty ?: continue
            val (domain, command) = parseMethod(call.method)
            val domainCommands = commandsByDomain[domain] ?: continue
            val spec = domainCommands[command] ?: continue

            val returnNames = spec.returns.map { it.name }.toSet()
            if (returnProp !in returnNames) {
                failures.add(
                    "${call.method}: returnProperty '$returnProp' not found in protocol spec " +
                        "(valid returns: ${returnNames.sorted()})"
                )
            }
        }
        assertTrue(failures.isEmpty(), failures.joinToString("\n", prefix = "\n"))
    }

    @Test
    fun `all required command parameters are present (warn on missing)`() {
        val warnings = mutableListOf<String>()
        for (call in allCommands) {
            val (domain, command) = parseMethod(call.method)
            val domainCommands = commandsByDomain[domain] ?: continue
            val spec = domainCommands[command] ?: continue

            val suppliedParams = call.params.map { it.removeSuffix("?") }.toSet()
            val requiredParams = spec.parameters.filter { !it.optional }.map { it.name }

            for (required in requiredParams) {
                if (required !in suppliedParams) {
                    warnings.add(
                        "${call.method}: required param '$required' not declared " +
                            "(valid required: $requiredParams)"
                    )
                }
            }
        }
        // NOTE: this is a soft assertion — some calls are intentionally partial
        // (e.g. dispatchMouse variants only send a subset).  Review the output
        // and annotate calls where missing required params are expected.
        if (warnings.isNotEmpty()) {
            println("⚠ Missing required params (review before release):")
            warnings.forEach { println("  - $it") }
        }
    }

    @Test
    fun `all CDP event subscriptions exist in protocol spec`() {
        val failures = mutableListOf<String>()
        for (event in allEvents) {
            val domainEvents = eventsByDomain[event.domain]
            if (domainEvents == null) {
                failures.add("${event.domain}.${event.event}: domain '${event.domain}' not found")
                continue
            }
            if (event.event !in domainEvents) {
                failures.add("${event.domain}.${event.event}: event not found " +
                    "(available: ${domainEvents.sorted()})")
            }
        }
        assertTrue(failures.isEmpty(), failures.joinToString("\n", prefix = "\n"))
    }

    @Test
    fun `protocol spec was loaded and contains expected domains`() {
        // Sanity-check that the JSON files were parsed correctly.
        assertFalse(spec.domains.isEmpty(), "No domains loaded — check protocol JSON files")
        val domainNames = spec.domains.map { it.domain }.toSet()
        val expected = listOf("Browser", "Page", "DOM", "Runtime", "Network", "Fetch", "Input")
        for (d in expected) {
            assertTrue(domainNames.contains(d), "Expected domain '$d' not in protocol spec")
        }
    }

    // ────────────────────────────────────────────────────────────────────

    /** Split "Domain.commandName" into (domain, commandName). */
    private fun parseMethod(method: String): Pair<String, String> {
        val dot = method.indexOf('.')
        require(dot > 0) { "Invalid CDP method format: '$method' (expected Domain.command)" }
        return method.substring(0, dot) to method.substring(dot + 1)
    }
}
