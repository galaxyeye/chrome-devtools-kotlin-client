@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.emulation

import kotlin.Int
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Screen orientation.
 */
@Serializable
data class ScreenOrientation(
  @property:SerialName("type")
  val type: ScreenOrientationType,
  @property:SerialName("angle")
  val angle: Int,
)
