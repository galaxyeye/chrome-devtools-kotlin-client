package ai.platon.cdt.kt.protocol.types.security

import com.fasterxml.jackson.`annotation`.JsonProperty
import java.lang.Deprecated
import kotlin.Boolean

/**
 * Information about insecure content on the page.
 */
@Deprecated
public data class InsecureContentStatus(
  @field:JsonProperty("ranMixedContent")
  public val ranMixedContent: Boolean,
  @field:JsonProperty("displayedMixedContent")
  public val displayedMixedContent: Boolean,
  @field:JsonProperty("containedMixedForm")
  public val containedMixedForm: Boolean,
  @field:JsonProperty("ranContentWithCertErrors")
  public val ranContentWithCertErrors: Boolean,
  @field:JsonProperty("displayedContentWithCertErrors")
  public val displayedContentWithCertErrors: Boolean,
  @field:JsonProperty("ranInsecureContentStyle")
  public val ranInsecureContentStyle: SecurityState,
  @field:JsonProperty("displayedInsecureContentStyle")
  public val displayedInsecureContentStyle: SecurityState,
)
