@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String

/**
 * Authorization challenge for HTTP status code 401 or 407.
 */
@Experimental
@Serializable
data class AuthChallenge(
  @SerialName("source")
  @param:Optional
  val source: AuthChallengeSource? = null,
  @SerialName("origin")
  val origin: String,
  @SerialName("scheme")
  val scheme: String,
  @SerialName("realm")
  val realm: String,
)
