@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.page

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String
import kotlin.collections.List

@Experimental
data class OriginTrial(
  @param:JsonProperty("trialName")
  val trialName: String,
  @param:JsonProperty("status")
  val status: OriginTrialStatus,
  @param:JsonProperty("tokensWithStatus")
  val tokensWithStatus: List<OriginTrialTokenWithStatus>,
)
