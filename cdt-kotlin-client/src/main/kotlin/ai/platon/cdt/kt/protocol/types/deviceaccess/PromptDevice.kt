@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.deviceaccess

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Device information displayed in a user prompt to select a device.
 */
data class PromptDevice(
  @param:JsonProperty("id")
  val id: String,
  @param:JsonProperty("name")
  val name: String,
)
