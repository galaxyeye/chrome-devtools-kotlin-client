@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.security
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.types.security.VisibleSecurityState

/**
 * The security state of the page changed.
 */
@Experimental
@Serializable
data class VisibleSecurityStateChanged(
  @SerialName("visibleSecurityState")
  val visibleSecurityState: VisibleSecurityState,
)
