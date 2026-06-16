@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.storage

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.Double
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Pair of issuer origin and number of available (signed, but not used) Trust
 * Tokens from that issuer.
 */
@Serializable
@Experimental
data class TrustTokens(
  @property:SerialName("issuerOrigin")
  val issuerOrigin: String,
  @property:SerialName("count")
  val count: Double,
)
