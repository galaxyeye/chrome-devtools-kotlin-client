@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.fetch

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Authorization challenge for HTTP status code 401 or 407.
 */
@Serializable
data class AuthChallenge(
  @property:SerialName("source")
  @param:Optional
  val source: AuthChallengeSource? = null,
  @property:SerialName("origin")
  val origin: String,
  @property:SerialName("scheme")
  val scheme: String,
  @property:SerialName("realm")
  val realm: String,
)
