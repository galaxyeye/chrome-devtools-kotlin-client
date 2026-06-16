@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.media

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Corresponds to kMediaPropertyChange
 */
@Serializable
data class PlayerProperty(
  @property:SerialName("name")
  val name: String,
  @property:SerialName("value")
  val `value`: String,
)
