@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.deviceaccess

import ai.platon.cdt.kt.serialization.protocol.types.deviceaccess.PromptDevice
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A device request opened a user prompt to select a device. Respond with the
 * selectPrompt or cancelPrompt command.
 */
@Serializable
data class DeviceRequestPrompted(
  @property:SerialName("id")
  val id: String,
  @property:SerialName("devices")
  val devices: List<PromptDevice>,
)
