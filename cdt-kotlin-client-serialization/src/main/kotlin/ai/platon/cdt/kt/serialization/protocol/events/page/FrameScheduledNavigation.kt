@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.page

import ai.platon.cdt.kt.serialization.protocol.types.page.ClientNavigationReason
import kotlin.Deprecated
import kotlin.Double
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired when frame schedules a potential navigation.
 */
@Serializable
@Deprecated("Deprecated")
data class FrameScheduledNavigation(
  @property:SerialName("frameId")
  val frameId: String,
  @property:SerialName("delay")
  val delay: Double,
  @property:SerialName("reason")
  val reason: ClientNavigationReason,
  @property:SerialName("url")
  val url: String,
)
