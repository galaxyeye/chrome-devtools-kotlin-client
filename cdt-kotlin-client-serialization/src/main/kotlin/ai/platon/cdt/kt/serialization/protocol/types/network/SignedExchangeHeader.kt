@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

/**
 * Information about a signed exchange header.
 * https://wicg.github.io/webpackage/draft-yasskin-httpbis-origin-signed-exchanges-impl.html#cbor-representation
 */
@Serializable
@Experimental
data class SignedExchangeHeader(
  @property:SerialName("requestUrl")
  val requestUrl: String,
  @property:SerialName("responseCode")
  val responseCode: Int,
  @property:SerialName("responseHeaders")
  val responseHeaders: JsonObject?,
  @property:SerialName("signatures")
  val signatures: List<SignedExchangeSignature>,
  @property:SerialName("headerIntegrity")
  val headerIntegrity: String,
)
