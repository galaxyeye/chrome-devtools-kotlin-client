@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Session event details specific to challenges.
 */
@Serializable
@Experimental
data class ChallengeEventDetails(
  @property:SerialName("challengeResult")
  val challengeResult: ChallengeEventDetailsChallengeResult,
  @property:SerialName("challenge")
  val challenge: String,
)
