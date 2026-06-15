@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.dom
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.Int
import kotlin.collections.List

/**
 * Fired when `Element`'s inline style is modified via a CSS property modification.
 */
@Experimental
@Serializable
data class InlineStyleInvalidated(
  @SerialName("nodeIds")
  val nodeIds: List<Int>,
)
