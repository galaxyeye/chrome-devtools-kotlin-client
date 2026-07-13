@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.performancetimeline

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Double
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TimelineEvent(
  @property:SerialName("frameId")
  val frameId: String,
  @property:SerialName("type")
  val type: String,
  @property:SerialName("name")
  val name: String,
  @property:SerialName("time")
  val time: Double,
  @property:SerialName("duration")
  @param:Optional
  val duration: Double? = null,
  @property:SerialName("lcpDetails")
  @param:Optional
  val lcpDetails: LargestContentfulPaint? = null,
  @property:SerialName("layoutShiftDetails")
  @param:Optional
  val layoutShiftDetails: LayoutShift? = null,
)
