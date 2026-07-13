@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.emulation

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.Deprecated
import kotlin.String
import kotlin.collections.List

/**
 * Used to specify User Agent Client Hints to emulate. See https://wicg.github.io/ua-client-hints
 * Missing optional values will be filled in by the target with what it would normally use.
 */
@Experimental
data class UserAgentMetadata(
  @param:JsonProperty("brands")
  @param:Optional
  val brands: List<UserAgentBrandVersion>? = null,
  @param:JsonProperty("fullVersionList")
  @param:Optional
  val fullVersionList: List<UserAgentBrandVersion>? = null,
  @param:JsonProperty("fullVersion")
  @param:Optional
  @Deprecated("Deprecated by protocol")
  val fullVersion: String? = null,
  @param:JsonProperty("platform")
  val platform: String,
  @param:JsonProperty("platformVersion")
  val platformVersion: String,
  @param:JsonProperty("architecture")
  val architecture: String,
  @param:JsonProperty("model")
  val model: String,
  @param:JsonProperty("mobile")
  val mobile: Boolean,
  @param:JsonProperty("bitness")
  @param:Optional
  val bitness: String? = null,
  @param:JsonProperty("wow64")
  @param:Optional
  val wow64: Boolean? = null,
  @param:JsonProperty("formFactors")
  @param:Optional
  val formFactors: List<String>? = null,
)
