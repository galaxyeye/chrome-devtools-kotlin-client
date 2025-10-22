package ai.platon.cdt.kt.protocol.types.network

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.String

public data class ResponseBody(
  @field:JsonProperty("body")
  public val body: String,
  @field:JsonProperty("base64Encoded")
  public val base64Encoded: Boolean,
)
