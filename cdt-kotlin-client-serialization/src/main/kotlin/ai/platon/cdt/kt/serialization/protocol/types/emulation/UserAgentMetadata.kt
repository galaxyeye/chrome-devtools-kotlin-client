@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.emulation
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Boolean
import kotlin.String
import kotlin.collections.List

/**
 * Used to specify User Agent Cient Hints to emulate. See https://wicg.github.io/ua-client-hints
 * Missing optional values will be filled in by the target with what it would normally use.
 */
@Experimental
@Serializable
data class UserAgentMetadata(
  @SerialName("brands")
  @param:Optional
  val brands: List<UserAgentBrandVersion>? = null,
  @SerialName("fullVersion")
  @param:Optional
  val fullVersion: String? = null,
  @SerialName("platform")
  val platform: String,
  @SerialName("platformVersion")
  val platformVersion: String,
  @SerialName("architecture")
  val architecture: String,
  @SerialName("model")
  val model: String,
  @SerialName("mobile")
  val mobile: Boolean,
)
