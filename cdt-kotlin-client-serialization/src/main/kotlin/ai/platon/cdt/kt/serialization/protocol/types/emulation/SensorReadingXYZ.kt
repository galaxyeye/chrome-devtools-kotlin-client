@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.emulation

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.Double
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Experimental
data class SensorReadingXYZ(
  @property:SerialName("x")
  val x: Double,
  @property:SerialName("y")
  val y: Double,
  @property:SerialName("z")
  val z: Double,
)
