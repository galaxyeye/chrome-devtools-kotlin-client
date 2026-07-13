@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.security

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.types.security.VisibleSecurityState
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The security state of the page changed.
 */
@Serializable
@Experimental
data class VisibleSecurityStateChanged(
  @property:SerialName("visibleSecurityState")
  val visibleSecurityState: VisibleSecurityState,
)
