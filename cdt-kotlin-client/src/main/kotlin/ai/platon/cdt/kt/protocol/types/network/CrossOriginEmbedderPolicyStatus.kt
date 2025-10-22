package ai.platon.cdt.kt.protocol.types.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

@Experimental
public data class CrossOriginEmbedderPolicyStatus(
  @field:JsonProperty("value")
  public val `value`: CrossOriginEmbedderPolicyValue,
  @field:JsonProperty("reportOnlyValue")
  public val reportOnlyValue: CrossOriginEmbedderPolicyValue,
  @field:JsonProperty("reportingEndpoint")
  @param:Optional
  public val reportingEndpoint: String? = null,
  @field:JsonProperty("reportOnlyReportingEndpoint")
  @param:Optional
  public val reportOnlyReportingEndpoint: String? = null,
)
