@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.security

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * An explanation of an factor contributing to the security state.
 */
@Serializable
data class SecurityStateExplanation(
  @property:SerialName("securityState")
  val securityState: SecurityState,
  @property:SerialName("title")
  val title: String,
  @property:SerialName("summary")
  val summary: String,
  @property:SerialName("description")
  val description: String,
  @property:SerialName("mixedContentType")
  val mixedContentType: MixedContentType,
  @property:SerialName("certificate")
  val certificate: List<String>,
  @property:SerialName("recommendations")
  @param:Optional
  val recommendations: List<String>? = null,
)
