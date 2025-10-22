package ai.platon.cdt.kt.protocol.types.tracing

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.String

data class RequestMemoryDump(
  @field:JsonProperty("dumpGuid")
  val dumpGuid: String,
  @field:JsonProperty("success")
  val success: Boolean,
)
