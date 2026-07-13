@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Experimental
data class OriginTrial(
  @property:SerialName("trialName")
  val trialName: String,
  @property:SerialName("status")
  val status: OriginTrialStatus,
  @property:SerialName("tokensWithStatus")
  val tokensWithStatus: List<OriginTrialTokenWithStatus>,
)
