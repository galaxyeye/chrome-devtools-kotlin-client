@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.fetch
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.String

/**
 * Response HTTP header entry
 */
@Serializable
data class HeaderEntry(
  @SerialName("name")
  val name: String,
  @SerialName("value")
  val `value`: String,
)
