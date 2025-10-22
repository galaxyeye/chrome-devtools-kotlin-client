package ai.platon.cdt.kt.protocol.types.emulation

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Used to specify User Agent Cient Hints to emulate. See https://wicg.github.io/ua-client-hints
 */
@Experimental
data class UserAgentBrandVersion(
  @field:JsonProperty("brand")
  val brand: String,
  @field:JsonProperty("version")
  val version: String,
)
