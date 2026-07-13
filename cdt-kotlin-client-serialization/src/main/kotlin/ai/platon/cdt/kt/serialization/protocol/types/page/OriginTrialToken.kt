@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Experimental
data class OriginTrialToken(
  @property:SerialName("origin")
  val origin: String,
  @property:SerialName("matchSubDomains")
  val matchSubDomains: Boolean,
  @property:SerialName("trialName")
  val trialName: String,
  @property:SerialName("expiryTime")
  val expiryTime: Double,
  @property:SerialName("isThirdParty")
  val isThirdParty: Boolean,
  @property:SerialName("usageRestriction")
  val usageRestriction: OriginTrialUsageRestriction,
)
