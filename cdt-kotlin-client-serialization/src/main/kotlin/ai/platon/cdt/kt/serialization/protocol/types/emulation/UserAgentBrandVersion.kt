@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.emulation

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Used to specify User Agent Client Hints to emulate. See https://wicg.github.io/ua-client-hints
 */
@Serializable
@Experimental
data class UserAgentBrandVersion(
  @property:SerialName("brand")
  val brand: String,
  @property:SerialName("version")
  val version: String,
)
