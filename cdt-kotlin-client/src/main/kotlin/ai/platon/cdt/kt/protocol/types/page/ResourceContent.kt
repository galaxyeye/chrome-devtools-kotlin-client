package ai.platon.cdt.kt.protocol.types.page

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.String

public data class ResourceContent(
  @field:JsonProperty("content")
  public val content: String,
  @field:JsonProperty("base64Encoded")
  public val base64Encoded: Boolean,
)
