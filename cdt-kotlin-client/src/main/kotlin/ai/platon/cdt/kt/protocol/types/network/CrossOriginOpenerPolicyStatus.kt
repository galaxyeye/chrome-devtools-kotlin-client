package ai.platon.cdt.kt.protocol.types.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

@Experimental
data class CrossOriginOpenerPolicyStatus(
  @field:JsonProperty("value")
  val `value`: CrossOriginOpenerPolicyValue,
  @field:JsonProperty("reportOnlyValue")
  val reportOnlyValue: CrossOriginOpenerPolicyValue,
  @field:JsonProperty("reportingEndpoint")
  @param:Optional
  val reportingEndpoint: String? = null,
  @field:JsonProperty("reportOnlyReportingEndpoint")
  @param:Optional
  val reportOnlyReportingEndpoint: String? = null,
)
