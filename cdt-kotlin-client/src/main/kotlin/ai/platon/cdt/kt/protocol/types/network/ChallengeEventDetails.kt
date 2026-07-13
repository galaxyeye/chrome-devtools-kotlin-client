@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Session event details specific to challenges.
 */
@Experimental
data class ChallengeEventDetails(
  @param:JsonProperty("challengeResult")
  val challengeResult: ChallengeEventDetailsChallengeResult,
  @param:JsonProperty("challenge")
  val challenge: String,
)
