@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.emulation
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Int

@Serializable
data class DisplayFeature(
  @SerialName("orientation")
  val orientation: DisplayFeatureOrientation,
  @SerialName("offset")
  val offset: Int,
  @SerialName("maskLength")
  val maskLength: Int,
)
