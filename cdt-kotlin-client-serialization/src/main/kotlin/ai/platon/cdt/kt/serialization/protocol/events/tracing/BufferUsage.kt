@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.tracing

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Double
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Experimental
data class BufferUsage(
  @property:SerialName("percentFull")
  @param:Optional
  val percentFull: Double? = null,
  @property:SerialName("eventCount")
  @param:Optional
  val eventCount: Double? = null,
  @property:SerialName("value")
  @param:Optional
  val `value`: Double? = null,
)
