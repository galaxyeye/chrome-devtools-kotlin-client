@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Int
import kotlin.String

/**
 * Information about a signed exchange response.
 */
@Experimental
@Serializable
data class SignedExchangeError(
  @SerialName("message")
  val message: String,
  @SerialName("signatureIndex")
  @param:Optional
  val signatureIndex: Int? = null,
  @SerialName("errorField")
  @param:Optional
  val errorField: SignedExchangeErrorField? = null,
)
