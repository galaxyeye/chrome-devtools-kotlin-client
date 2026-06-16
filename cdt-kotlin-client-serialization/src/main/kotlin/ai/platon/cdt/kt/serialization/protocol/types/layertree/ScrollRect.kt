@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.layertree

import ai.platon.cdt.kt.serialization.protocol.types.dom.Rect
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Rectangle where scrolling happens on the main thread.
 */
@Serializable
data class ScrollRect(
  @property:SerialName("rect")
  val rect: Rect,
  @property:SerialName("type")
  val type: ScrollRectType,
)
