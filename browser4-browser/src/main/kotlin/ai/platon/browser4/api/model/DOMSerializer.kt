package ai.platon.browser4.api.model

import kotlinx.serialization.json.Json

/**
 * Serializes DOM model objects to JSON using kotlinx.serialization.
 * Uses [encodeDefaults] = false to mimic Jackson's NON_EMPTY inclusion —
 * null and empty fields are omitted from the output.
 */
object DOMSerializer {
    private val domJson = Json {
        ignoreUnknownKeys = true
        isLenient = true
        coerceInputValues = true
        encodeDefaults = false
    }

    fun toJson(root: SerializableDOMTree): String = domJson.encodeToString(root)

    fun toJson(browserState: BrowserState): String = domJson.encodeToString(browserState)

    fun toJson(tabsState: List<TabState>): String = domJson.encodeToString(tabsState)

    fun toJson(nano: NanoDOMTree): String = domJson.encodeToString(nano)

    fun toJson(nodes: InteractiveDOMTreeNodeList): String = domJson.encodeToString(nodes)
}
