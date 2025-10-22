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
data class UserAgentMetadata(
  @field:JsonProperty("brands")
  @param:Optional
  val brands: List<UserAgentBrandVersion>? = null,
  @field:JsonProperty("fullVersion")
  @param:Optional
  val fullVersion: String? = null,
  @field:JsonProperty("platform")
  val platform: String,
  @field:JsonProperty("platformVersion")
  val platformVersion: String,
  @field:JsonProperty("architecture")
  val architecture: String,
  @field:JsonProperty("model")
  val model: String,
  @field:JsonProperty("mobile")
  val mobile: Boolean,
)
