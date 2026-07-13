@file:Suppress("unused")
package ai.platon.browser4.chrome.protocol.types.accessibility

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AXProperty(
  @property:SerialName("name")
  val name: AXPropertyName,
  @property:SerialName("value")
  val `value`: AXValue,
)
