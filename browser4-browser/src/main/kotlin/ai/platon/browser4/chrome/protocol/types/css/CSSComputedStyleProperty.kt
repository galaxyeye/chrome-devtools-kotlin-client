@file:Suppress("unused")
package ai.platon.browser4.chrome.protocol.types.css

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CSSComputedStyleProperty(
  @property:SerialName("name")
  val name: String,
  @property:SerialName("value")
  val `value`: String,
)
