package ai.platon.cdt.kt.protocol.types.io

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.String

data class Read(
  @field:JsonProperty("base64Encoded")
  @param:Optional
  val base64Encoded: Boolean? = null,
  @field:JsonProperty("data")
  val `data`: String,
  @field:JsonProperty("eof")
  val eof: Boolean,
)
