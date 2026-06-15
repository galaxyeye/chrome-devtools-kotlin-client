@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.security
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlin.collections.List

/**
 * An explanation of an factor contributing to the security state.
 */
@Serializable
data class SecurityStateExplanation(
  @SerialName("securityState")
  val securityState: SecurityState,
  @SerialName("title")
  val title: String,
  @SerialName("summary")
  val summary: String,
  @SerialName("description")
  val description: String,
  @SerialName("mixedContentType")
  val mixedContentType: MixedContentType,
  @SerialName("certificate")
  val certificate: List<String>,
  @SerialName("recommendations")
  @param:Optional
  val recommendations: List<String>? = null,
)
