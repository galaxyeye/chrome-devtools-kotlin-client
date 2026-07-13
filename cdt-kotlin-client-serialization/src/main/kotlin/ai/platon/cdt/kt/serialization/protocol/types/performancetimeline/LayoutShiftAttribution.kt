@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.performancetimeline

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.dom.Rect
import kotlin.Int
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LayoutShiftAttribution(
  @property:SerialName("previousRect")
  val previousRect: Rect,
  @property:SerialName("currentRect")
  val currentRect: Rect,
  @property:SerialName("nodeId")
  @param:Optional
  val nodeId: Int? = null,
)
