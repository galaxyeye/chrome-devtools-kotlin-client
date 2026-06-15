@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.page
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Deprecated
import kotlin.String

/**
 * Fired when frame no longer has a scheduled navigation.
 */
@Deprecated("Deprecated")
@Serializable
data class FrameClearedScheduledNavigation(
  @SerialName("frameId")
  val frameId: String,
)
