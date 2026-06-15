@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * Information about a signed exchange signature.
 * https://wicg.github.io/webpackage/draft-yasskin-httpbis-origin-signed-exchanges-impl.html#rfc.section.3.1
 */
@Experimental
@Serializable
data class SignedExchangeSignature(
  @SerialName("label")
  val label: String,
  @SerialName("signature")
  val signature: String,
  @SerialName("integrity")
  val integrity: String,
  @SerialName("certUrl")
  @param:Optional
  val certUrl: String? = null,
  @SerialName("certSha256")
  @param:Optional
  val certSha256: String? = null,
  @SerialName("validityUrl")
  val validityUrl: String,
  @SerialName("date")
  val date: Int,
  @SerialName("expires")
  val expires: Int,
  @SerialName("certificates")
  @param:Optional
  val certificates: List<String>? = null,
)
