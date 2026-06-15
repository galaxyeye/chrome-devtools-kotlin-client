@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.storage
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.Double
import kotlin.String

/**
 * Pair of issuer origin and number of available (signed, but not used) Trust
 * Tokens from that issuer.
 */
@Experimental
@Serializable
data class TrustTokens(
  @SerialName("issuerOrigin")
  val issuerOrigin: String,
  @SerialName("count")
  val count: Double,
)
