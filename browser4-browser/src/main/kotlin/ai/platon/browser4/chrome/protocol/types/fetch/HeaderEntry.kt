@file:Suppress("unused")
package ai.platon.browser4.chrome.protocol.types.fetch

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Response HTTP header entry
 */
@Serializable
data class HeaderEntry(
  @property:SerialName("name")
  val name: String,
  @property:SerialName("value")
  val `value`: String,
)
