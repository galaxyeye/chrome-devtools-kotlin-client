package ai.platon.pulsar.browser.driver.chrome

import ai.platon.cdt.kt.serialization.protocol.types.accessibility.AXNode
import ai.platon.pulsar.browser.driver.chrome.impl.EventDispatcher
import ai.platon.pulsar.common.ResourceLoader
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonObject
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ProtocolAXTreeTest {

    @Test
    @DisplayName("Given AXTree json then deserialize correctly by Json")
    fun givenAxtreeJsonThenDeserializeCorrectlyByJson() {
        val json = Json {
            ignoreUnknownKeys = true
            coerceInputValues = true
            isLenient = true
        }
        val content = ResourceLoader.readString("dom/AXTree.json")
        val jsonElement = json.parseToJsonElement(content)
        val jsonNodes = jsonElement.jsonObject["result"]?.jsonObject?.get("nodes")!!
        val dispatcher = EventDispatcher()
        // Deserialize a List<AXNode> using the generic-aware overload
        @Suppress("UNCHECKED_CAST")
        val nodes = dispatcher.deserialize(arrayOf(AXNode::class.java), List::class.java, jsonNodes) as List<AXNode>

        Assertions.assertTrue { nodes.isNotEmpty() }
    }

    @Test
    @DisplayName("Given AXTree json then deserialize correctly by EventDispatcher")
    fun givenAxtreeJsonThenDeserializeCorrectlyByEventDispatcher() {
        val json = EventDispatcher.JSON
        val content = ResourceLoader.readString("dom/AXTree.json")
        val jsonElement = json.parseToJsonElement(content)
        val jsonNodes = jsonElement.jsonObject["result"]?.jsonObject?.get("nodes")!!
        val dispatcher = EventDispatcher()
        @Suppress("UNCHECKED_CAST")
        val nodes = dispatcher.deserialize(arrayOf(AXNode::class.java), List::class.java, jsonNodes) as List<AXNode>

        Assertions.assertTrue { nodes.isNotEmpty() }
    }

    @Test
    @DisplayName("Given AXTree json WITH BAD FIELDS then deserialize correctly by EventDispatcher")
    fun givenAxtreeJsonWithBadFieldsThenDeserializeCorrectlyByEventdispatcher() {
        val json = EventDispatcher.JSON
        val content = ResourceLoader.readString("dom/AXTree.json")
            .replace("uninteresting", "UNINTERESTINGREPLACEDFORTEST")

        val jsonElement = json.parseToJsonElement(content)
        val jsonNodes = jsonElement.jsonObject["result"]?.jsonObject?.get("nodes")!!
        val dispatcher = EventDispatcher()
        @Suppress("UNCHECKED_CAST")
        val nodes = dispatcher.deserialize(arrayOf(AXNode::class.java), List::class.java, jsonNodes) as List<AXNode>

        Assertions.assertTrue { nodes.isNotEmpty() }
    }
}
