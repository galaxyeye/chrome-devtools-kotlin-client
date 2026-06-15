@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String

@Experimental
@Serializable
data class CrossOriginEmbedderPolicyStatus(
  @SerialName("value")
  val `value`: CrossOriginEmbedderPolicyValue,
  @SerialName("reportOnlyValue")
  val reportOnlyValue: CrossOriginEmbedderPolicyValue,
  @SerialName("reportingEndpoint")
  @param:Optional
  val reportingEndpoint: String? = null,
  @SerialName("reportOnlyReportingEndpoint")
  @param:Optional
  val reportOnlyReportingEndpoint: String? = null,
)
