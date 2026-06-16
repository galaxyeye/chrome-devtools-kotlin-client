@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.emulation

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Boolean
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Used to specify User Agent Cient Hints to emulate. See https://wicg.github.io/ua-client-hints
 * Missing optional values will be filled in by the target with what it would normally use.
 */
@Serializable
@Experimental
data class UserAgentMetadata(
  @property:SerialName("brands")
  @param:Optional
  val brands: List<UserAgentBrandVersion>? = null,
  @property:SerialName("fullVersion")
  @param:Optional
  val fullVersion: String? = null,
  @property:SerialName("platform")
  val platform: String,
  @property:SerialName("platformVersion")
  val platformVersion: String,
  @property:SerialName("architecture")
  val architecture: String,
  @property:SerialName("model")
  val model: String,
  @property:SerialName("mobile")
  val mobile: Boolean,
)
