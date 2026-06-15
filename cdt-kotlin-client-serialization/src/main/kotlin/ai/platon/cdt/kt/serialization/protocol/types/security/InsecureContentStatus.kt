@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.security
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Boolean
import kotlin.Deprecated

/**
 * Information about insecure content on the page.
 */
@Deprecated("Deprecated")
@Serializable
data class InsecureContentStatus(
  @SerialName("ranMixedContent")
  val ranMixedContent: Boolean,
  @SerialName("displayedMixedContent")
  val displayedMixedContent: Boolean,
  @SerialName("containedMixedForm")
  val containedMixedForm: Boolean,
  @SerialName("ranContentWithCertErrors")
  val ranContentWithCertErrors: Boolean,
  @SerialName("displayedContentWithCertErrors")
  val displayedContentWithCertErrors: Boolean,
  @SerialName("ranInsecureContentStyle")
  val ranInsecureContentStyle: SecurityState,
  @SerialName("displayedInsecureContentStyle")
  val displayedInsecureContentStyle: SecurityState,
)
