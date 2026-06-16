@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.page

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.types.page.ClientNavigationDisposition
import ai.platon.cdt.kt.serialization.protocol.types.page.ClientNavigationReason
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired when a renderer-initiated navigation is requested.
 * Navigation may still be cancelled after the event is issued.
 */
@Serializable
@Experimental
data class FrameRequestedNavigation(
  @property:SerialName("frameId")
  val frameId: String,
  @property:SerialName("reason")
  val reason: ClientNavigationReason,
  @property:SerialName("url")
  val url: String,
  @property:SerialName("disposition")
  val disposition: ClientNavigationDisposition,
)
