@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.performancetimeline

import kotlin.Boolean
import kotlin.Double
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * See https://wicg.github.io/layout-instability/#sec-layout-shift and layout_shift.idl
 */
@Serializable
data class LayoutShift(
  @property:SerialName("value")
  val `value`: Double,
  @property:SerialName("hadRecentInput")
  val hadRecentInput: Boolean,
  @property:SerialName("lastInputTime")
  val lastInputTime: Double,
  @property:SerialName("sources")
  val sources: List<LayoutShiftAttribution>,
)
