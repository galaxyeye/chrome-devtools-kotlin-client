package ai.platon.browser4.chrome.protocol

import ai.platon.browser4.chrome.protocol.transport.EventDispatcher
import ai.platon.pulsar.common.ResourceLoader
import ai.platon.cdt.kt.serialization.protocol.types.accessibility.AXNode
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.serializer
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ProtocolAXTreeTest {

    companion object {
        val JSON = Json {
            ignoreUnknownKeys = true
            isLenient = true
            coerceInputValues = true
        }
    }

    @Test
    @DisplayName("Given AXTree json then deserialize correctly by kotlinx.serialization JSON")
    fun givenAxtreeJsonThenDeserializeCorrectlyByKotlinxSerialization() {
        val jsonString = ResourceLoader.readString("dom/AXTree.json")
        val jsonElement = JSON.parseToJsonElement(jsonString)
        val jsonNodes = jsonElement.jsonObject.getValue("result").jsonObject.getValue("nodes")
        val nodes: List<AXNode> = JSON.decodeFromJsonElement(ListSerializer(AXNode.serializer()), jsonNodes)

        Assertions.assertTrue { nodes.isNotEmpty() }
    }

    @Test
    @DisplayName("Given AXTree json then deserialize correctly by EventDispatcher")
    fun givenAxtreeJsonThenDeserializeCorrectlyByEventDispatcher() {
        val dispatcher = EventDispatcher()
        val str = ResourceLoader.readString("dom/AXTree.json")
        val json = dispatcher.patchMessageForProtocolChange(str)

        val jsonElement = EventDispatcher.JSON.parseToJsonElement(json)
        val jsonNodes = jsonElement.jsonObject.getValue("result").jsonObject.getValue("nodes")
        // Deserialize a List<AXNode> using the generic-aware overload
        @Suppress("UNCHECKED_CAST")
        val nodes = dispatcher.deserialize(arrayOf(AXNode::class.java), List::class.java, jsonNodes) as List<AXNode>

        Assertions.assertTrue { nodes.isNotEmpty() }
    }

    @Test
    @DisplayName("Given AXTree json WITH BAD FIELDS then deserialize correctly by EventDispatcher")
    fun givenAxtreeJsonWithBadFieldsThenDeserializeCorrectlyByEventDispatcher() {
        val json = ResourceLoader.readString("dom/AXTree.json")
//            .replace("uninteresting", "UNINTERESTINGREPLACEDFORTEST") // for old protocol, no need to replace since 4.8.1

        val jsonElement = EventDispatcher.JSON.parseToJsonElement(json)
        val jsonNodes = jsonElement.jsonObject.getValue("result").jsonObject.getValue("nodes")
        val dispatcher = EventDispatcher()
        // Deserialize a List<AXNode> using the generic-aware overload
        @Suppress("UNCHECKED_CAST")
        val nodes = dispatcher.deserialize(arrayOf(AXNode::class.java), List::class.java, jsonNodes) as List<AXNode>

        Assertions.assertTrue { nodes.isNotEmpty() }
    }
}
