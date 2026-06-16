@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.emulation

import kotlin.Int
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DisplayFeature(
  @property:SerialName("orientation")
  val orientation: DisplayFeatureOrientation,
  @property:SerialName("offset")
  val offset: Int,
  @property:SerialName("maskLength")
  val maskLength: Int,
)
