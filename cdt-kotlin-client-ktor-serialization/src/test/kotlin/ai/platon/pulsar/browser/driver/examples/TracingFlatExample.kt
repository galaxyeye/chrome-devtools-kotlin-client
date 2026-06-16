@file:OptIn(InternalSerializationApi::class)

package ai.platon.pulsar.browser.driver.examples

import ai.platon.cdt.kt.serialization.protocol.events.tracing.DataCollected
import ai.platon.cdt.kt.serialization.protocol.support.types.EventHandler
import ai.platon.pulsar.browser.driver.chrome.ChromeLauncher
import ai.platon.pulsar.browser.driver.chrome.RemoteDevTools
import ai.platon.pulsar.browser.driver.chrome.impl.BrowserProtocol
import ai.platon.pulsar.browser.driver.chrome.impl.DirectChromeProtocol
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.*
import kotlinx.serialization.serializer
import java.nio.file.Paths

private data class EmptyResult(val ignored: String? = null)

suspend fun main() {
    val launcher = ChromeLauncher()
    val chromeService = launcher.launch(false)
    val tab = chromeService.createTab()
    val devTools: RemoteDevTools = chromeService.createDevToolsService(tab)
    val bp: BrowserProtocol = DirectChromeProtocol(devTools)

    val dataCollectedList = mutableListOf<Any>()

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

            @Suppress("UNCHECKED_CAST")
            val jsonArray = buildJsonArray {
                dataCollectedList.forEach { item ->
                    val serializer = item::class.serializer() as KSerializer<Any>
                    add(Json.encodeToJsonElement(serializer, item))
                }
            }
            path.toFile().writeText(Json { prettyPrint = true }.encodeToString(jsonArray))
            devTools.close()
        }, Any::class.java
    )

    devTools.addEventListener(
        "Page", "loadEventFired",
        EventHandler {
            devTools.execute("Tracing.end", null, EmptyResult::class)
        }, Any::class.java
    )

    bp.pageEnable()
    devTools.execute("Tracing.start", null, EmptyResult::class)
    bp.navigate("https://github.com")
}
