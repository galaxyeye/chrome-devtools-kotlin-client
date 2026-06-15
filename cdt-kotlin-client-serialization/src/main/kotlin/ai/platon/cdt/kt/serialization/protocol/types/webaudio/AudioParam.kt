@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.webaudio
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Double
import kotlin.String

/**
 * Protocol object for AudioParam
 */
@Serializable
data class AudioParam(
  @SerialName("paramId")
  val paramId: String,
  @SerialName("nodeId")
  val nodeId: String,
  @SerialName("contextId")
  val contextId: String,
  @SerialName("paramType")
  val paramType: String,
  @SerialName("rate")
  val rate: AutomationRate,
  @SerialName("defaultValue")
  val defaultValue: Double,
  @SerialName("minValue")
  val minValue: Double,
  @SerialName("maxValue")
  val maxValue: Double,
)
