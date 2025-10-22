package ai.platon.cdt.kt.protocol.types.security

import com.fasterxml.jackson.`annotation`.JsonProperty
import java.lang.Deprecated
import kotlin.Boolean

/**
 * Information about insecure content on the page.
 */
@Deprecated
data class InsecureContentStatus(
  @field:JsonProperty("ranMixedContent")
  val ranMixedContent: Boolean,
  @field:JsonProperty("displayedMixedContent")
  val displayedMixedContent: Boolean,
  @field:JsonProperty("containedMixedForm")
  val containedMixedForm: Boolean,
  @field:JsonProperty("ranContentWithCertErrors")
  val ranContentWithCertErrors: Boolean,
  @field:JsonProperty("displayedContentWithCertErrors")
  val displayedContentWithCertErrors: Boolean,
  @field:JsonProperty("ranInsecureContentStyle")
  val ranInsecureContentStyle: SecurityState,
  @field:JsonProperty("displayedInsecureContentStyle")
  val displayedInsecureContentStyle: SecurityState,
)
