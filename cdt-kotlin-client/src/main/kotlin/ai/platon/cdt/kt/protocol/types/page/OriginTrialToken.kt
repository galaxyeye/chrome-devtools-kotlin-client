@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.page

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.Double
import kotlin.String

@Experimental
data class OriginTrialToken(
  @param:JsonProperty("origin")
  val origin: String,
  @param:JsonProperty("matchSubDomains")
  val matchSubDomains: Boolean,
  @param:JsonProperty("trialName")
  val trialName: String,
  @param:JsonProperty("expiryTime")
  val expiryTime: Double,
  @param:JsonProperty("isThirdParty")
  val isThirdParty: Boolean,
  @param:JsonProperty("usageRestriction")
  val usageRestriction: OriginTrialUsageRestriction,
)
