package ai.platon.cdt.kt.protocol.events.tracing

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double

public data class BufferUsage(
  @field:JsonProperty("percentFull")
  @param:Optional
  public val percentFull: Double? = null,
  @field:JsonProperty("eventCount")
  @param:Optional
  public val eventCount: Double? = null,
  @field:JsonProperty("value")
  @param:Optional
  public val `value`: Double? = null,
)
