package ai.platon.cdt.kt.protocol.types.security

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String
import kotlin.collections.List

/**
 * An explanation of an factor contributing to the security state.
 */
public data class SecurityStateExplanation(
  @field:JsonProperty("securityState")
  public val securityState: SecurityState,
  @field:JsonProperty("title")
  public val title: String,
  @field:JsonProperty("summary")
  public val summary: String,
  @field:JsonProperty("description")
  public val description: String,
  @field:JsonProperty("mixedContentType")
  public val mixedContentType: MixedContentType,
  @field:JsonProperty("certificate")
  public val certificate: List<String>,
  @field:JsonProperty("recommendations")
  @param:Optional
  public val recommendations: List<String>? = null,
)
