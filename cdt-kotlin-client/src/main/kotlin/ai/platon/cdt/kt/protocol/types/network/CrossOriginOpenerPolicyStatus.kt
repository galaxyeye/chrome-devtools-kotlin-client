package ai.platon.cdt.kt.protocol.types.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

@Experimental
public data class CrossOriginOpenerPolicyStatus(
  @field:JsonProperty("value")
  public val `value`: CrossOriginOpenerPolicyValue,
  @field:JsonProperty("reportOnlyValue")
  public val reportOnlyValue: CrossOriginOpenerPolicyValue,
  @field:JsonProperty("reportingEndpoint")
  @param:Optional
  public val reportingEndpoint: String? = null,
  @field:JsonProperty("reportOnlyReportingEndpoint")
  @param:Optional
  public val reportOnlyReportingEndpoint: String? = null,
)
