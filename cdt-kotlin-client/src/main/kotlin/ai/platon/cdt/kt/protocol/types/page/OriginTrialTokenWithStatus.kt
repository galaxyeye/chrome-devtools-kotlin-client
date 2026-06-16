@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.page

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

@Experimental
data class OriginTrialTokenWithStatus(
  @param:JsonProperty("rawTokenText")
  val rawTokenText: String,
  @param:JsonProperty("parsedToken")
  @param:Optional
  val parsedToken: OriginTrialToken? = null,
  @param:JsonProperty("status")
  val status: OriginTrialTokenStatus,
)
