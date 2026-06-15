@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.page
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.types.page.ClientNavigationReason
import kotlin.Deprecated
import kotlin.Double
import kotlin.String

/**
 * Fired when frame schedules a potential navigation.
 */
@Deprecated("Deprecated")
@Serializable
data class FrameScheduledNavigation(
  @SerialName("frameId")
  val frameId: String,
  @SerialName("delay")
  val delay: Double,
  @SerialName("reason")
  val reason: ClientNavigationReason,
  @SerialName("url")
  val url: String,
)
