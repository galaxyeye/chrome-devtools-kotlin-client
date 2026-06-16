@file:Suppress("unused")
package ai.platon.browser4.chrome.protocol.types.page

import ai.platon.browser4.chrome.protocol.support.annotations.Experimental
import kotlin.Boolean
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Additional information about the frame document's security origin.
 */
@Serializable
@Experimental
data class SecurityOriginDetails(
  @property:SerialName("isLocalhost")
  val isLocalhost: Boolean,
)
