@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String

/**
 * Response to an AuthChallenge.
 */
@Experimental
@Serializable
data class AuthChallengeResponse(
  @SerialName("response")
  val response: AuthChallengeResponseResponse,
  @SerialName("username")
  @param:Optional
  val username: String? = null,
  @SerialName("password")
  @param:Optional
  val password: String? = null,
)
