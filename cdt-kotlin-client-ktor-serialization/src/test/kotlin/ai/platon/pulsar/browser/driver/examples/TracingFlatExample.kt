package ai.platon.pulsar.browser.driver.examples

import ai.platon.cdt.kt.serialization.protocol.events.page.LoadEventFired
import ai.platon.cdt.kt.serialization.protocol.events.tracing.DataCollected
import ai.platon.cdt.kt.serialization.protocol.events.tracing.TracingComplete
import ai.platon.cdt.kt.serialization.protocol.support.types.EventHandler
import ai.platon.pulsar.browser.driver.chrome.ChromeLauncher
import ai.platon.pulsar.browser.driver.chrome.RemoteDevTools
import ai.platon.pulsar.browser.driver.chrome.impl.BrowserProtocol
import ai.platon.pulsar.browser.driver.chrome.impl.DirectChromeProtocol
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.buildJsonArray
import java.nio.file.Paths

private val json = Json { prettyPrint = true }

private data class EmptyResult(val ignored: String? = null)

suspend fun main() {
    val launcher = ChromeLauncher()
    val chromeService = launcher.launch(false)
    val tab = chromeService.createTab()
    val devTools: RemoteDevTools = chromeService.createDevToolsService(tab)
    val bp: BrowserProtocol = DirectChromeProtocol(devTools)

    val dataCollectedList = mutableListOf<JsonObject?>()

    devTools.addEventListener(
        "Tracing", "dataCollected",
        EventHandler { event ->
            dataCollectedList.addAll((event as DataCollected).value)
        }, DataCollected::class.java
    )

    devTools.addEventListener(
        "Tracing", "tracingComplete",
        EventHandler {
            val path = Paths.get("/tmp/tracing.json")
            println("Tracing completed! Dumping to $path")

            val jsonArray = buildJsonArray {
                dataCollectedList.forEach { item ->
                    if (item != null) {
                        add(item)
                    }
                }
            }
            path.toFile().writeText(json.encodeToString(JsonArray.serializer(), jsonArray))
            devTools.close()
        }, TracingComplete::class.java
    )

    devTools.addEventListener(
        "Page", "loadEventFired",
        EventHandler {
            devTools.execute("Tracing.end", null, EmptyResult::class)
        }, LoadEventFired::class.java
    )

    bp.pageEnable()
    devTools.execute("Tracing.start", null, EmptyResult::class)
    bp.navigate("https://github.com")
}
