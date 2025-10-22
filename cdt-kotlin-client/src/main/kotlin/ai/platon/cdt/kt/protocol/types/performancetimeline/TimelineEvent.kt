package ai.platon.cdt.kt.protocol.types.performancetimeline

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String

data class TimelineEvent(
  @field:JsonProperty("frameId")
  val frameId: String,
  @field:JsonProperty("type")
  val type: String,
  @field:JsonProperty("name")
  val name: String,
  @field:JsonProperty("time")
  val time: Double,
  @field:JsonProperty("duration")
  @param:Optional
  val duration: Double? = null,
  @field:JsonProperty("lcpDetails")
  @param:Optional
  val lcpDetails: LargestContentfulPaint? = null,
  @field:JsonProperty("layoutShiftDetails")
  @param:Optional
  val layoutShiftDetails: LayoutShift? = null,
)
