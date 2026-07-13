@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Information about a signed exchange response.
 */
@Serializable
@Experimental
data class SignedExchangeError(
  @property:SerialName("message")
  val message: String,
  @property:SerialName("signatureIndex")
  @param:Optional
  val signatureIndex: Int? = null,
  @property:SerialName("errorField")
  @param:Optional
  val errorField: SignedExchangeErrorField? = null,
)
