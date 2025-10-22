package ai.platon.cdt.kt.protocol.types.security

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

@Experimental
public data class SafetyTipInfo(
  @field:JsonProperty("safetyTipStatus")
  public val safetyTipStatus: SafetyTipStatus,
  @field:JsonProperty("safeUrl")
  @param:Optional
  public val safeUrl: String? = null,
)
