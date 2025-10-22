package ai.platon.cdt.kt.protocol.types.audits

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

public data class EncodedResponse(
  @field:JsonProperty("body")
  @param:Optional
  public val body: String? = null,
  @field:JsonProperty("originalSize")
  public val originalSize: Int,
  @field:JsonProperty("encodedSize")
  public val encodedSize: Int,
)
