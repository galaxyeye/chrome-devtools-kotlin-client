@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.emulation

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.Double
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Experimental
data class SensorReadingSingle(
  @property:SerialName("value")
  val `value`: Double,
)
