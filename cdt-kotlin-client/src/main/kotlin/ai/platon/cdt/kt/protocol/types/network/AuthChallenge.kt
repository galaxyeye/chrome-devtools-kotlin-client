package ai.platon.cdt.kt.protocol.types.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Authorization challenge for HTTP status code 401 or 407.
 */
@Experimental
public data class AuthChallenge(
  @field:JsonProperty("source")
  @param:Optional
  public val source: AuthChallengeSource? = null,
  @field:JsonProperty("origin")
  public val origin: String,
  @field:JsonProperty("scheme")
  public val scheme: String,
  @field:JsonProperty("realm")
  public val realm: String,
)
