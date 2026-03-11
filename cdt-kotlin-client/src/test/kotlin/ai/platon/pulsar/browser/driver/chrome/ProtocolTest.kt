package ai.platon.pulsar.browser.driver.chrome

import ai.platon.cdt.kt.protocol.types.accessibility.AXNode
import ai.platon.pulsar.browser.driver.chrome.impl.EventDispatcher
import ai.platon.pulsar.common.ResourceLoader
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ProtocolTest {

    @Test
    @DisplayName("Given AXTree json then deserialize correctly by OBJECT_MAPPER")
    fun givenAxtreeJsonThenDeserializeCorrectlyByObjectMapper() {
        val mapper = EventDispatcher.OBJECT_MAPPER
        val json = ResourceLoader.readString("dom/AXTree.json")
        val jsonNode = mapper.readTree(json)
        val jsonNodes = jsonNode.get("result").get("nodes")
        val nodes: List<AXNode> = mapper.readerFor(List::class.java).readValue(jsonNodes)

        Assertions.assertTrue { nodes.isNotEmpty() }
    }

    @Test
    @DisplayName("Given AXTree json then deserialize correctly by EventDispatcher")
    fun givenAxtreeJsonThenDeserializeCorrectlyByEventDispatcher() {
        val mapper = EventDispatcher.OBJECT_MAPPER
        val json = ResourceLoader.readString("dom/AXTree.json")
        val jsonNode = mapper.readTree(json)
        val jsonNodes = jsonNode.get("result").get("nodes")
        val dispatcher = EventDispatcher()
        // Deserialize a List<AXNode> using the generic-aware overload
        @Suppress("UNCHECKED_CAST")
        val nodes = dispatcher.deserialize(arrayOf(AXNode::class.java), List::class.java, jsonNodes) as List<AXNode>

        Assertions.assertTrue { nodes.isNotEmpty() }
        // Assertions.assertEquals(AXPropertyName.UNKNOWN, nodes.first().properties?.get(1)?.name)
    }

    @Test
    @DisplayName("Given AXTree json WITH BAD FIELDS then deserialize correctly by EventDispatcher")
    fun givenAxtreeJsonWithBadFieldsThenDeserializeCorrectlyByEventdispatcher() {
        val mapper = EventDispatcher.OBJECT_MAPPER
        val json = ResourceLoader.readString("dom/AXTree.json")
            .replace("uninteresting", "UNINTERESTINGREPLACEDFORTEST")

        val jsonNode = mapper.readTree(json)
        val jsonNodes = jsonNode.get("result").get("nodes")
        val dispatcher = EventDispatcher()
        // Deserialize a List<AXNode> using the generic-aware overload
        @Suppress("UNCHECKED_CAST")
        val nodes = dispatcher.deserialize(arrayOf(AXNode::class.java), List::class.java, jsonNodes) as List<AXNode>

        Assertions.assertTrue { nodes.isNotEmpty() }
        // Assertions.assertEquals(AXPropertyName.UNKNOWN, nodes[1].ignoredReasons?.first()?.name)
    }
}
