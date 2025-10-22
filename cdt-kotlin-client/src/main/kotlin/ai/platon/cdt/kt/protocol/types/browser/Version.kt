package ai.platon.cdt.kt.protocol.types.browser

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

public data class Version(
  @field:JsonProperty("protocolVersion")
  public val protocolVersion: String,
  @field:JsonProperty("product")
  public val product: String,
  @field:JsonProperty("revision")
  public val revision: String,
  @field:JsonProperty("userAgent")
  public val userAgent: String,
  @field:JsonProperty("jsVersion")
  public val jsVersion: String,
)
