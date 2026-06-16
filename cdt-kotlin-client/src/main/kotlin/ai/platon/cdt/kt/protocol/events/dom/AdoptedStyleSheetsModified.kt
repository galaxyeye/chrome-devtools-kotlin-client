@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.dom

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * Fired when `Element`'s adoptedStyleSheets are modified.
 */
@Experimental
data class AdoptedStyleSheetsModified(
  @param:JsonProperty("nodeId")
  val nodeId: Int,
  @param:JsonProperty("adoptedStyleSheets")
  @param:Experimental
  val adoptedStyleSheets: List<String>,
)
