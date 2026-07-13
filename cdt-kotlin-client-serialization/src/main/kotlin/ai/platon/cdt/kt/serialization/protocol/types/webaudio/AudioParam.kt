@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.webaudio

import kotlin.Double
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Protocol object for AudioParam
 */
@Serializable
data class AudioParam(
  @property:SerialName("paramId")
  val paramId: String,
  @property:SerialName("nodeId")
  val nodeId: String,
  @property:SerialName("contextId")
  val contextId: String,
  @property:SerialName("paramType")
  val paramType: String,
  @property:SerialName("rate")
  val rate: AutomationRate,
  @property:SerialName("defaultValue")
  val defaultValue: Double,
  @property:SerialName("minValue")
  val minValue: Double,
  @property:SerialName("maxValue")
  val maxValue: Double,
)
