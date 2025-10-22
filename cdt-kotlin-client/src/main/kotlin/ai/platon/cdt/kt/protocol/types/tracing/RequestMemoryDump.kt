package ai.platon.cdt.kt.protocol.types.tracing

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.String

public data class RequestMemoryDump(
  @field:JsonProperty("dumpGuid")
  public val dumpGuid: String,
  @field:JsonProperty("success")
  public val success: Boolean,
)
