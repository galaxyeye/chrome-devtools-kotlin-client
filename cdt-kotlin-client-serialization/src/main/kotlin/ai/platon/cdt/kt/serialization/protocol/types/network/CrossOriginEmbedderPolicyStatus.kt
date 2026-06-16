@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Experimental
data class CrossOriginEmbedderPolicyStatus(
  @property:SerialName("value")
  val `value`: CrossOriginEmbedderPolicyValue,
  @property:SerialName("reportOnlyValue")
  val reportOnlyValue: CrossOriginEmbedderPolicyValue,
  @property:SerialName("reportingEndpoint")
  @param:Optional
  val reportingEndpoint: String? = null,
  @property:SerialName("reportOnlyReportingEndpoint")
  @param:Optional
  val reportOnlyReportingEndpoint: String? = null,
)
