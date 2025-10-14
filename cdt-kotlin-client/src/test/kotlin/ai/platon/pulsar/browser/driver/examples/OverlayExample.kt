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
package ai.platon.pulsar.browser.driver.examples

import ai.platon.cdt.kt.protocol.events.overlay.ScreenshotRequested
import com.google.gson.GsonBuilder
import ai.platon.cdt.kt.protocol.support.types.EventHandler
import ai.platon.cdt.kt.protocol.support.types.EventListener
import ai.platon.cdt.kt.protocol.types.dom.RGBA
import ai.platon.cdt.kt.protocol.types.overlay.HighlightConfig
import kotlinx.coroutines.runBlocking

class OverlayExample: BrowserExampleBase() {

    override val testUrl: String = "https://www.amazon.com/"

    override suspend fun run() {
        page.enable()
        dom.enable()
        overlay.enable()

        overlay.onScreenshotRequested(object: EventHandler<ScreenshotRequested> {
            override suspend fun onEvent(event: ScreenshotRequested) {
                val v = event.viewport
                overlay.highlightRect(v.x.toInt(), v.y.toInt(), v.width.toInt(), v.height.toInt())
            }
        })

        overlay.onScreenshotRequested { screenshot: ScreenshotRequested ->
            val v = screenshot.viewport
            overlay.highlightRect(v.x.toInt(), v.y.toInt(), v.width.toInt(), v.height.toInt())
        }
//        dom.onGetDocument {
//            val document = it.root
//            val body = document.body
//            val rect = body.boundingBox
//            val highlightConfig = HighlightConfig(RGBA(255, 0, 0, 0.5), RGBA(255, 0, 0, 0.5))
//            overlay.highlightRect(rect.x.toInt(), rect.y.toInt(), rect.width.toInt(), rect.height.toInt(), highlightConfig)
//        }
        page.navigate(testUrl)
        page.onDocumentOpened {
            page.captureScreenshot()
            highlight("#nav-xshop")
        }
    }

    private suspend fun highlight(selector: String) {
        val documentId = dom.getDocument().nodeId
        val nodeId = dom.querySelector(documentId, selector)
        val highlightConfig = HighlightConfig().apply {
            showInfo = true
            showRulers = true
            showStyles = true
            showExtensionLines = true
            shapeColor = RGBA(255, 0, 0, 1.0)
        }

        overlay.highlightRect(300, 400, 500, 500)
//        Thread.sleep(5000)
        overlay.highlightNode(highlightConfig, nodeId, null, null, selector)
//        Thread.sleep(5000)
        val obj = overlay.getHighlightObjectForTest(nodeId)
        val json = GsonBuilder().setPrettyPrinting().create().toJson(obj)
        println(json)
    }
}

suspend fun main() {
    OverlayExample().use { it.run() }
}
