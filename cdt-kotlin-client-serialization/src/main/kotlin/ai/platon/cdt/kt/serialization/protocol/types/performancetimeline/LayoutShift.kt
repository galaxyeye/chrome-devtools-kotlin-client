@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.performancetimeline
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Boolean
import kotlin.Double
import kotlin.collections.List

/**
 * See https://wicg.github.io/layout-instability/#sec-layout-shift and layout_shift.idl
 */
@Serializable
data class LayoutShift(
  @SerialName("value")
  val `value`: Double,
  @SerialName("hadRecentInput")
  val hadRecentInput: Boolean,
  @SerialName("lastInputTime")
  val lastInputTime: Double,
  @SerialName("sources")
  val sources: List<LayoutShiftAttribution>,
)
