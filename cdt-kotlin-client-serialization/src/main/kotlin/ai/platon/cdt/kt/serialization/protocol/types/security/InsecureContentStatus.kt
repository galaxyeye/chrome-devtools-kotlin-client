@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.security

import kotlin.Boolean
import kotlin.Deprecated
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Information about insecure content on the page.
 */
@Serializable
@Deprecated("Deprecated")
data class InsecureContentStatus(
  @property:SerialName("ranMixedContent")
  val ranMixedContent: Boolean,
  @property:SerialName("displayedMixedContent")
  val displayedMixedContent: Boolean,
  @property:SerialName("containedMixedForm")
  val containedMixedForm: Boolean,
  @property:SerialName("ranContentWithCertErrors")
  val ranContentWithCertErrors: Boolean,
  @property:SerialName("displayedContentWithCertErrors")
  val displayedContentWithCertErrors: Boolean,
  @property:SerialName("ranInsecureContentStyle")
  val ranInsecureContentStyle: SecurityState,
  @property:SerialName("displayedInsecureContentStyle")
  val displayedInsecureContentStyle: SecurityState,
)
