package ai.platon.cdt.kt.protocol.types.audits

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

data class EncodedResponse(
  @field:JsonProperty("body")
  @param:Optional
  val body: String? = null,
  @field:JsonProperty("originalSize")
  val originalSize: Int,
  @field:JsonProperty("encodedSize")
  val encodedSize: Int,
)
