package ai.platon.cdt.kt.protocol.types.security

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String
import kotlin.collections.List

/**
 * An explanation of an factor contributing to the security state.
 */
data class SecurityStateExplanation(
  @field:JsonProperty("securityState")
  val securityState: SecurityState,
  @field:JsonProperty("title")
  val title: String,
  @field:JsonProperty("summary")
  val summary: String,
  @field:JsonProperty("description")
  val description: String,
  @field:JsonProperty("mixedContentType")
  val mixedContentType: MixedContentType,
  @field:JsonProperty("certificate")
  val certificate: List<String>,
  @field:JsonProperty("recommendations")
  @param:Optional
  val recommendations: List<String>? = null,
)
