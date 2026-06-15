@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.emulation
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.String

/**
 * Used to specify User Agent Cient Hints to emulate. See https://wicg.github.io/ua-client-hints
 */
@Experimental
@Serializable
data class UserAgentBrandVersion(
  @SerialName("brand")
  val brand: String,
  @SerialName("version")
  val version: String,
)
