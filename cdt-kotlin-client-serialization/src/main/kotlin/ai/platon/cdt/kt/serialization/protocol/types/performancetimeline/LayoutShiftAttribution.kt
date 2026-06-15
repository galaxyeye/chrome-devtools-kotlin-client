@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.performancetimeline
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.dom.Rect
import kotlin.Int

@Serializable
data class LayoutShiftAttribution(
  @SerialName("previousRect")
  val previousRect: Rect,
  @SerialName("currentRect")
  val currentRect: Rect,
  @SerialName("nodeId")
  @param:Optional
  val nodeId: Int? = null,
)
