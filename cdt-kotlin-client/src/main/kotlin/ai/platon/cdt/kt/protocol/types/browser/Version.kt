package ai.platon.cdt.kt.protocol.types.browser

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

data class Version(
  @field:JsonProperty("protocolVersion")
  val protocolVersion: String,
  @field:JsonProperty("product")
  val product: String,
  @field:JsonProperty("revision")
  val revision: String,
  @field:JsonProperty("userAgent")
  val userAgent: String,
  @field:JsonProperty("jsVersion")
  val jsVersion: String,
)
