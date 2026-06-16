@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Information about a signed exchange response.
 */
@Serializable
@Experimental
data class SignedExchangeInfo(
  @property:SerialName("outerResponse")
  val outerResponse: Response,
  @property:SerialName("header")
  @param:Optional
  val `header`: SignedExchangeHeader? = null,
  @property:SerialName("securityDetails")
  @param:Optional
  val securityDetails: SecurityDetails? = null,
  @property:SerialName("errors")
  @param:Optional
  val errors: List<SignedExchangeError>? = null,
)
