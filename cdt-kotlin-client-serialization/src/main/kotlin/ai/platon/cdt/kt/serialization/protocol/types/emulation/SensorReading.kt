@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.emulation

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Experimental
data class SensorReading(
  @property:SerialName("single")
  @param:Optional
  val single: SensorReadingSingle? = null,
  @property:SerialName("xyz")
  @param:Optional
  val xyz: SensorReadingXYZ? = null,
  @property:SerialName("quaternion")
  @param:Optional
  val quaternion: SensorReadingQuaternion? = null,
)
