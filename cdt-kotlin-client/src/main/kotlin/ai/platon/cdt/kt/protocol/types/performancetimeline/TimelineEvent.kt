package ai.platon.cdt.kt.protocol.types.performancetimeline

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String

public data class TimelineEvent(
  @field:JsonProperty("frameId")
  public val frameId: String,
  @field:JsonProperty("type")
  public val type: String,
  @field:JsonProperty("name")
  public val name: String,
  @field:JsonProperty("time")
  public val time: Double,
  @field:JsonProperty("duration")
  @param:Optional
  public val duration: Double? = null,
  @field:JsonProperty("lcpDetails")
  @param:Optional
  public val lcpDetails: LargestContentfulPaint? = null,
  @field:JsonProperty("layoutShiftDetails")
  @param:Optional
  public val layoutShiftDetails: LayoutShift? = null,
)
