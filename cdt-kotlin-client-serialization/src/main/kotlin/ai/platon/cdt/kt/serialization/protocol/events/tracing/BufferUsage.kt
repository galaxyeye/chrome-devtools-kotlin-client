@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.tracing
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Double

@Serializable
data class BufferUsage(
  @SerialName("percentFull")
  @param:Optional
  val percentFull: Double? = null,
  @SerialName("eventCount")
  @param:Optional
  val eventCount: Double? = null,
  @SerialName("value")
  @param:Optional
  val `value`: Double? = null,
)
