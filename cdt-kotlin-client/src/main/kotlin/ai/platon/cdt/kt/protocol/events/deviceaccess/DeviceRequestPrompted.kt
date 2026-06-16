@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.deviceaccess

import ai.platon.cdt.kt.protocol.types.deviceaccess.PromptDevice
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String
import kotlin.collections.List

/**
 * A device request opened a user prompt to select a device. Respond with the
 * selectPrompt or cancelPrompt command.
 */
data class DeviceRequestPrompted(
  @param:JsonProperty("id")
  val id: String,
  @param:JsonProperty("devices")
  val devices: List<PromptDevice>,
)
