package ai.platon.browser4.api.model

import ai.platon.browser4.api.model.*
import ai.platon.pulsar.common.serialize.json.doubleBindModule
import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

object DOMSerializer {
    val MAPPER: ObjectMapper = jacksonObjectMapper().apply {
        setDefaultPropertyInclusion(JsonInclude.Include.NON_EMPTY)
        registerModule(doubleBindModule())
    }

    fun toJson(root: SerializableDOMTree): String {
        return MAPPER.writeValueAsString(root)
    }

    fun toJson(browserState: BrowserState): String {
        return MAPPER.writeValueAsString(browserState)
    }

    fun toJson(tabsState: List<TabState>): String {
        return MAPPER.writeValueAsString(tabsState)
    }

    // serialize nano tree
    fun toJson(nano: NanoDOMTree): String {
        return MAPPER.writeValueAsString(nano)
    }

    // serialize nano tree
    fun toJson(nodes: InteractiveDOMTreeNodeList): String {
        return MAPPER.writeValueAsString(nodes)
    }
}
