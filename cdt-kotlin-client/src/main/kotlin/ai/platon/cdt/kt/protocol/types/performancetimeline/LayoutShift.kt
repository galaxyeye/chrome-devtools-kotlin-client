package ai.platon.cdt.kt.protocol.types.performancetimeline

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.Double
import kotlin.collections.List

/**
 * See https://wicg.github.io/layout-instability/#sec-layout-shift and layout_shift.idl
 */
data class LayoutShift(
  @field:JsonProperty("value")
  val `value`: Double,
  @field:JsonProperty("hadRecentInput")
  val hadRecentInput: Boolean,
  @field:JsonProperty("lastInputTime")
  val lastInputTime: Double,
  @field:JsonProperty("sources")
  val sources: List<LayoutShiftAttribution>,
)
