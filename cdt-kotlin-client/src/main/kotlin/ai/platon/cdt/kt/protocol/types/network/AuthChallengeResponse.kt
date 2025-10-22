package ai.platon.cdt.kt.protocol.types.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Response to an AuthChallenge.
 */
@Experimental
public data class AuthChallengeResponse(
  @field:JsonProperty("response")
  public val response: AuthChallengeResponseResponse,
  @field:JsonProperty("username")
  @param:Optional
  public val username: String? = null,
  @field:JsonProperty("password")
  @param:Optional
  public val password: String? = null,
)
