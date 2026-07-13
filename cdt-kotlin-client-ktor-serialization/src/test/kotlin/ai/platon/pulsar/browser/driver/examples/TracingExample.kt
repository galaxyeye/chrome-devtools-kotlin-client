package ai.platon.pulsar.browser.driver.examples

import ai.platon.cdt.kt.serialization.protocol.events.page.LoadEventFired
import ai.platon.cdt.kt.serialization.protocol.events.tracing.DataCollected
import ai.platon.cdt.kt.serialization.protocol.events.tracing.TracingComplete
import ai.platon.cdt.kt.serialization.protocol.support.types.EventHandler
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.buildJsonArray
import java.io.IOException
import java.nio.file.Path
import java.nio.file.Paths

class TracingExample : BrowserExampleBase() {

    override val testUrl: String = "https://www.stbchina.cn/"

    private data class EmptyResult(val ignored: String? = null)

    companion object {
        private val json = Json { prettyPrint = true }
    }

    override suspend fun run() {
        val dataCollectedList = mutableListOf<JsonObject?>()

        // Add tracing data to dataCollectedList
        remoteDevTools.addEventListener(
            "Tracing", "dataCollected",
            EventHandler { event ->
                dataCollectedList.addAll((event as DataCollected).value)
            }, DataCollected::class.java
        )

        // When tracing is complete, dump dataCollectedList to JSON file.
        remoteDevTools.addEventListener(
            "Tracing", "tracingComplete",
            EventHandler {
                val path = Paths.get("/tmp/tracing.json")
                println("Tracing completed! Dumping to $path")
                dump(path, dataCollectedList)
                remoteDevTools.close()
            }, TracingComplete::class.java
        )

        remoteDevTools.addEventListener(
            "Page", "loadEventFired",
            EventHandler { remoteDevTools.execute("Tracing.end", null, EmptyResult::class) },
            LoadEventFired::class.java
        )

        devTools.pageEnable()
        remoteDevTools.execute("Tracing.start", null, EmptyResult::class)
        devTools.navigate(testUrl)
    }

    private fun dump(path: Path, data: List<JsonObject?>) {
        try {
            val jsonArray = buildJsonArray {
                data.forEach { item ->
                    if (item != null) {
                        add(item)
                    }
                }
            }
            val jsonString = json.encodeToString(JsonArray.serializer(), jsonArray)
            path.toFile().writeText(jsonString)
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
}

suspend fun main() {
    TracingExample().use { it.run() }
}
