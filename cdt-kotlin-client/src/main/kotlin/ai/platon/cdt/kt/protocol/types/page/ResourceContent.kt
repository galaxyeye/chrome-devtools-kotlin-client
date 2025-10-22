package ai.platon.cdt.kt.protocol.types.page

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.String

data class ResourceContent(
  @field:JsonProperty("content")
  val content: String,
  @field:JsonProperty("base64Encoded")
  val base64Encoded: Boolean,
)
