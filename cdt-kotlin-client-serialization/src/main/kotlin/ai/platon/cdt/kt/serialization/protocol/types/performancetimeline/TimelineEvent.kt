@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.performancetimeline
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Double
import kotlin.String

@Serializable
data class TimelineEvent(
  @SerialName("frameId")
  val frameId: String,
  @SerialName("type")
  val type: String,
  @SerialName("name")
  val name: String,
  @SerialName("time")
  val time: Double,
  @SerialName("duration")
  @param:Optional
  val duration: Double? = null,
  @SerialName("lcpDetails")
  @param:Optional
  val lcpDetails: LargestContentfulPaint? = null,
  @SerialName("layoutShiftDetails")
  @param:Optional
  val layoutShiftDetails: LayoutShift? = null,
)
