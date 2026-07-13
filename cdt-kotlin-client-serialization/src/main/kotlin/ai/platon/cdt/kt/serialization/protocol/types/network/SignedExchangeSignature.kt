@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Information about a signed exchange signature.
 * https://wicg.github.io/webpackage/draft-yasskin-httpbis-origin-signed-exchanges-impl.html#rfc.section.3.1
 */
@Serializable
@Experimental
data class SignedExchangeSignature(
  @property:SerialName("label")
  val label: String,
  @property:SerialName("signature")
  val signature: String,
  @property:SerialName("integrity")
  val integrity: String,
  @property:SerialName("certUrl")
  @param:Optional
  val certUrl: String? = null,
  @property:SerialName("certSha256")
  @param:Optional
  val certSha256: String? = null,
  @property:SerialName("validityUrl")
  val validityUrl: String,
  @property:SerialName("date")
  val date: Int,
  @property:SerialName("expires")
  val expires: Int,
  @property:SerialName("certificates")
  @param:Optional
  val certificates: List<String>? = null,
)
