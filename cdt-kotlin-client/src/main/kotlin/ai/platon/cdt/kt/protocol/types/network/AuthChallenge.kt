package ai.platon.cdt.kt.protocol.types.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Authorization challenge for HTTP status code 401 or 407.
 */
@Experimental
data class AuthChallenge(
  @field:JsonProperty("source")
  @param:Optional
  val source: AuthChallengeSource? = null,
  @field:JsonProperty("origin")
  val origin: String,
  @field:JsonProperty("scheme")
  val scheme: String,
  @field:JsonProperty("realm")
  val realm: String,
)
