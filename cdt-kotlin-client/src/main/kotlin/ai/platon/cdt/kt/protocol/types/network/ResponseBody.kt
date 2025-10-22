package ai.platon.cdt.kt.protocol.types.network

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.String

data class ResponseBody(
  @field:JsonProperty("body")
  val body: String,
  @field:JsonProperty("base64Encoded")
  val base64Encoded: Boolean,
)
