package ai.platon.cdt.kt.protocol.types.emulation

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.String
import kotlin.collections.List

/**
 * Used to specify User Agent Cient Hints to emulate. See https://wicg.github.io/ua-client-hints
 * Missing optional values will be filled in by the target with what it would normally use.
 */
@Experimental
public data class UserAgentMetadata(
  @field:JsonProperty("brands")
  @param:Optional
  public val brands: List<UserAgentBrandVersion>? = null,
  @field:JsonProperty("fullVersion")
  @param:Optional
  public val fullVersion: String? = null,
  @field:JsonProperty("platform")
  public val platform: String,
  @field:JsonProperty("platformVersion")
  public val platformVersion: String,
  @field:JsonProperty("architecture")
  public val architecture: String,
  @field:JsonProperty("model")
  public val model: String,
  @field:JsonProperty("mobile")
  public val mobile: Boolean,
)
