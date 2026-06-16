@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.page

import kotlin.Deprecated
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired when frame no longer has a scheduled navigation.
 */
@Serializable
@Deprecated("Deprecated")
data class FrameClearedScheduledNavigation(
  @property:SerialName("frameId")
  val frameId: String,
)
