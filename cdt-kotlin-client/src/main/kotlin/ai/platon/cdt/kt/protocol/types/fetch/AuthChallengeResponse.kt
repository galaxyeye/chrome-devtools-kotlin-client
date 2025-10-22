package ai.platon.cdt.kt.protocol.types.fetch

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Response to an AuthChallenge.
 */
data class AuthChallengeResponse(
  @field:JsonProperty("response")
  val response: AuthChallengeResponseResponse,
  @field:JsonProperty("username")
  @param:Optional
  val username: String? = null,
  @field:JsonProperty("password")
  @param:Optional
  val password: String? = null,
)
