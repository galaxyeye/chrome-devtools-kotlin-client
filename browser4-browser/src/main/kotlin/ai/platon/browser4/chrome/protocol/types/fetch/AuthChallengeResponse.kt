@file:Suppress("unused")
package ai.platon.browser4.chrome.protocol.types.fetch

import ai.platon.browser4.chrome.protocol.support.annotations.Optional
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Response to an AuthChallenge.
 */
@Serializable
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
