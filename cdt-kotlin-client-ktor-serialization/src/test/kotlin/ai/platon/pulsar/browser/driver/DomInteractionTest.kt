/*-
 * #%L
 * cdt-kotlin-client
 * %%
 * Copyright (C) 2025 platon.ai
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package ai.platon.pulsar.browser.driver

import ai.platon.pulsar.browser.driver.chrome.ChromeLauncher
import ai.platon.pulsar.browser.driver.chrome.RemoteChrome
import ai.platon.pulsar.browser.driver.chrome.RemoteDevTools
import ai.platon.pulsar.browser.driver.chrome.common.LauncherOptions
import ai.platon.pulsar.browser.driver.chrome.impl.BrowserProtocol
import ai.platon.pulsar.common.browser.BrowserFiles
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.booleanOrNull
import kotlinx.serialization.json.doubleOrNull
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class DomInteractionTest {
    private lateinit var assetServer: TestAssetServer
    private lateinit var launcher: ChromeLauncher
    private lateinit var chrome: RemoteChrome
    private lateinit var devTools: RemoteDevTools
    private lateinit var protocol: BrowserProtocol

    @BeforeEach
    fun setUp() {
        assetServer = TestAssetServer.start()

        val userDataDir = BrowserFiles.computeTestContextDir()
        launcher = ChromeLauncher(userDataDir, options = LauncherOptions())
        chrome = launcher.launch()
        val tab = chrome.createTab()
        devTools = chrome.createDevTools(tab)
        protocol = BrowserProtocol.create(devTools)

        runBlocking {
            protocol.pageEnable()
            protocol.domEnable()
            protocol.runtimeEnable()
        }
    }

    @AfterEach
    fun tearDown() {
        if (::chrome.isInitialized) {
            chrome.close()
        }
        if (::launcher.isInitialized) {
            launcher.close()
        }
        if (::assetServer.isInitialized) {
            assetServer.close()
        }
    }

    @Test
    fun shouldNavigateAndInteractWithPageControls() = runBlocking {
        navigateTo("/title.html")
        assertEquals("Woof-Woof", evaluateString("document.title"))

        navigateTo("/input/textarea.html")
        focus("textarea")
        assertTrue(evaluateBoolean("document.activeElement === document.querySelector('textarea')"))
        protocol.insertText("hello from cdt")
        assertEquals("hello from cdt", evaluateString("window.result"))

        navigateTo("/input/checkbox.html")
        click("input")
        val checkboxResult = evaluateString("JSON.stringify(window.result)")
        assertTrue(checkboxResult.contains("\"check\":true"))
        assertTrue(checkboxResult.contains("\"click\""))

        navigateTo("/input/scrollable.html")
        val buttonSelector = "#button-99"
        val scrollBefore = evaluateNumber("window.scrollY")
        click(buttonSelector)
        assertEquals("clicked", evaluateString("document.querySelector('$buttonSelector').textContent"))
        assertTrue(evaluateNumber("window.scrollY") > scrollBefore, "expected page scroll while clicking off-screen button")
    }

    @Test
    fun shouldRetrieveHtmlAndText() = runBlocking {
        navigateTo("/dom.html")

        val nodeId = querySelector("#outer")
        val node = protocol.describeNode(nodeId = nodeId)
        val outerHtml = protocol.getOuterHTML(nodeId = node.nodeId, backendNodeId = node.backendNodeId)
        assertTrue(outerHtml.contains("id=\"outer\""))
        assertTrue(outerHtml.contains("<div id=\"inner\">Text,"))

        val innerText = evaluateString("document.querySelector('#inner').textContent")
        assertEquals("Text,\nmore text", innerText)
    }

    private suspend fun navigateTo(path: String) {
        protocol.navigate(assetServer.url(path))
        waitForDocumentReady(path)
    }

    private suspend fun focus(selector: String) {
        protocol.focus(nodeId = querySelector(selector))
    }

    private suspend fun click(selector: String) {
        val nodeId = querySelector(selector)
        protocol.scrollIntoViewIfNeeded(nodeId = nodeId)

        val model = protocol.getBoxModel(nodeId = nodeId)
        val x = centerCoordinate(model.content, 0)
        val y = centerCoordinate(model.content, 1)

        protocol.dispatchMouseMoved(x = x, y = y, buttons = null)
        protocol.dispatchMousePressed(x = x, y = y, clickCount = 1, modifiers = null, buttons = 1)
        protocol.dispatchMouseReleased(x = x, y = y, clickCount = 1, modifiers = null, buttons = 0)
    }

    private suspend fun querySelector(selector: String): Int {
        val document = protocol.getDocument()
        return protocol.querySelector(document.nodeId, selector)
    }

    private suspend fun waitForDocumentReady(path: String, timeoutMillis: Long = 5_000L) {
        val startTime = System.currentTimeMillis()
        while (System.currentTimeMillis() - startTime < timeoutMillis) {
            val isReady = evaluateBoolean(
                "window.location.pathname === '$path' && document.readyState === 'complete'"
            )
            if (isReady) {
                return
            }
            delay(100)
        }

        throw AssertionError("Timed out waiting for $path to finish loading")
    }

    private suspend fun evaluateString(expression: String): String {
        val result = protocol.evaluate(expression).result.value
        return when (result) {
            is JsonPrimitive -> result.content
            else -> result?.toString() ?: ""
        }
    }

    private suspend fun evaluateBoolean(expression: String): Boolean {
        val value = protocol.evaluate(expression).result.value
        return when (value) {
            is JsonPrimitive -> value.booleanOrNull ?: false
            else -> false
        }
    }

    private suspend fun evaluateNumber(expression: String): Double {
        val value = protocol.evaluate(expression).result.value
        return when (value) {
            is JsonPrimitive -> value.doubleOrNull ?: value.content.toDoubleOrNull() ?: 0.0
            else -> 0.0
        }
    }

    private fun centerCoordinate(quad: List<Double>, offset: Int): Double {
        return (quad[offset] + quad[offset + 2] + quad[offset + 4] + quad[offset + 6]) / 4.0
    }
}
