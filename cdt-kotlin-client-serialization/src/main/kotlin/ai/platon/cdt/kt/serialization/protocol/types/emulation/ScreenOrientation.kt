@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.emulation
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Int

/**
 * Screen orientation.
 */
@Serializable
data class ScreenOrientation(
  @SerialName("type")
  val type: ScreenOrientationType,
  @SerialName("angle")
  val angle: Int,
)
