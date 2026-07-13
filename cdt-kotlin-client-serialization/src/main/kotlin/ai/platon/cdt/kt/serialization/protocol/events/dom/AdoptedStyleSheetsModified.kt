@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.dom

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired when `Element`'s adoptedStyleSheets are modified.
 */
@Serializable
@Experimental
data class AdoptedStyleSheetsModified(
  @property:SerialName("nodeId")
  val nodeId: Int,
  @property:SerialName("adoptedStyleSheets")
  @param:Experimental
  val adoptedStyleSheets: List<String>,
)
