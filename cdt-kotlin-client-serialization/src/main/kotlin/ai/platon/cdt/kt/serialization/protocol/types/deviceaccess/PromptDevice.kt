@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.deviceaccess

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Device information displayed in a user prompt to select a device.
 */
@Serializable
data class PromptDevice(
  @property:SerialName("id")
  val id: String,
  @property:SerialName("name")
  val name: String,
)
