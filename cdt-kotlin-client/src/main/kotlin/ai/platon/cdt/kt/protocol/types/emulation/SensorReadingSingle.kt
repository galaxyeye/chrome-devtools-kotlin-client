@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.emulation

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double

@Experimental
data class SensorReadingSingle(
  @param:JsonProperty("value")
  val `value`: Double,
)
