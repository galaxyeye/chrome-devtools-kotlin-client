@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.emulation

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double

@Experimental
data class SensorReadingQuaternion(
  @param:JsonProperty("x")
  val x: Double,
  @param:JsonProperty("y")
  val y: Double,
  @param:JsonProperty("z")
  val z: Double,
  @param:JsonProperty("w")
  val w: Double,
)
