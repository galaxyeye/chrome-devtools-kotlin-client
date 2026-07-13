@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.dom

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.Int
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired when `Element`'s inline style is modified via a CSS property modification.
 */
@Serializable
@Experimental
data class InlineStyleInvalidated(
  @property:SerialName("nodeIds")
  val nodeIds: List<Int>,
)
