@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.collections.List

/**
 * Information about a signed exchange response.
 */
@Experimental
@Serializable
data class SignedExchangeInfo(
  @SerialName("outerResponse")
  val outerResponse: Response,
  @SerialName("header")
  @param:Optional
  val `header`: SignedExchangeHeader? = null,
  @SerialName("securityDetails")
  @param:Optional
  val securityDetails: SecurityDetails? = null,
  @SerialName("errors")
  @param:Optional
  val errors: List<SignedExchangeError>? = null,
)
