@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.Any
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map

/**
 * Information about a signed exchange header.
 * https://wicg.github.io/webpackage/draft-yasskin-httpbis-origin-signed-exchanges-impl.html#cbor-representation
 */
@Experimental
@Serializable
data class SignedExchangeHeader(
  @SerialName("requestUrl")
  val requestUrl: String,
  @SerialName("responseCode")
  val responseCode: Int,
  @SerialName("responseHeaders")
  val responseHeaders: Map<String, Any?>,
  @SerialName("signatures")
  val signatures: List<SignedExchangeSignature>,
  @SerialName("headerIntegrity")
  val headerIntegrity: String,
)
