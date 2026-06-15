@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String

@Experimental
@Serializable
data class CrossOriginOpenerPolicyStatus(
  @SerialName("value")
  val `value`: CrossOriginOpenerPolicyValue,
  @SerialName("reportOnlyValue")
  val reportOnlyValue: CrossOriginOpenerPolicyValue,
  @SerialName("reportingEndpoint")
  @param:Optional
  val reportingEndpoint: String? = null,
  @SerialName("reportOnlyReportingEndpoint")
  @param:Optional
  val reportOnlyReportingEndpoint: String? = null,
)
