package ai.platon.cdt.kt.protocol.events.tracing

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double

data class BufferUsage(
  @field:JsonProperty("percentFull")
  @param:Optional
  val percentFull: Double? = null,
  @field:JsonProperty("eventCount")
  @param:Optional
  val eventCount: Double? = null,
  @field:JsonProperty("value")
  @param:Optional
  val `value`: Double? = null,
)
