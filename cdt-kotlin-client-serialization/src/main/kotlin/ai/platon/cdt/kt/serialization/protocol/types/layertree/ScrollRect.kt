@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.layertree
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.types.dom.Rect

/**
 * Rectangle where scrolling happens on the main thread.
 */
@Serializable
data class ScrollRect(
  @SerialName("rect")
  val rect: Rect,
  @SerialName("type")
  val type: ScrollRectType,
)
