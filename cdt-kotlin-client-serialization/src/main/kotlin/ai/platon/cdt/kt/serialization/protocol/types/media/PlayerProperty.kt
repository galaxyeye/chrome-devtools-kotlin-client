@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.media
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.String

/**
 * Corresponds to kMediaPropertyChange
 */
@Serializable
data class PlayerProperty(
  @SerialName("name")
  val name: String,
  @SerialName("value")
  val `value`: String,
)
