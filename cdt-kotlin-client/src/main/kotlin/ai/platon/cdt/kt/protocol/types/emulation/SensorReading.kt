@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.emulation

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty

@Experimental
data class SensorReading(
  @param:JsonProperty("single")
  @param:Optional
  val single: SensorReadingSingle? = null,
  @param:JsonProperty("xyz")
  @param:Optional
  val xyz: SensorReadingXYZ? = null,
  @param:JsonProperty("quaternion")
  @param:Optional
  val quaternion: SensorReadingQuaternion? = null,
)
