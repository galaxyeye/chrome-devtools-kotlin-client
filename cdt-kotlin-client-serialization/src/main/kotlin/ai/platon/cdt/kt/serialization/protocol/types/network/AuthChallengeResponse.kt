@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Response to an AuthChallenge.
 */
@Serializable
@Experimental
data class AuthChallengeResponse(
  @property:SerialName("response")
  val response: AuthChallengeResponseResponse,
  @property:SerialName("username")
  @param:Optional
  val username: String? = null,
  @property:SerialName("password")
  @param:Optional
  val password: String? = null,
)
