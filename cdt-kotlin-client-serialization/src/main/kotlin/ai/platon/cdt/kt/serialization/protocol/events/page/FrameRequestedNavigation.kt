@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.page
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.types.page.ClientNavigationDisposition
import ai.platon.cdt.kt.serialization.protocol.types.page.ClientNavigationReason
import kotlin.String

/**
 * Fired when a renderer-initiated navigation is requested.
 * Navigation may still be cancelled after the event is issued.
 */
@Experimental
@Serializable
data class FrameRequestedNavigation(
  @SerialName("frameId")
  val frameId: String,
  @SerialName("reason")
  val reason: ClientNavigationReason,
  @SerialName("url")
  val url: String,
  @SerialName("disposition")
  val disposition: ClientNavigationDisposition,
)
