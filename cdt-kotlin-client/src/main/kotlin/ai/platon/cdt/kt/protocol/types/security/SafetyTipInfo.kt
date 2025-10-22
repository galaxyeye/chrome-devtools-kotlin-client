package ai.platon.cdt.kt.protocol.types.security

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

@Experimental
data class SafetyTipInfo(
  @field:JsonProperty("safetyTipStatus")
  val safetyTipStatus: SafetyTipStatus,
  @field:JsonProperty("safeUrl")
  @param:Optional
  val safeUrl: String? = null,
)
