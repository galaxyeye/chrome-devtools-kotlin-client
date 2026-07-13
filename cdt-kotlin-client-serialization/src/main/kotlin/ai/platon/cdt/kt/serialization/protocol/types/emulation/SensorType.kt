@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.emulation

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Used to specify sensor types to emulate.
 * See https://w3c.github.io/sensors/#automation for more information.
 */
@Serializable
public enum class SensorType {
  @SerialName("absolute-orientation")
  ABSOLUTE_ORIENTATION,
  @SerialName("accelerometer")
  ACCELEROMETER,
  @SerialName("ambient-light")
  AMBIENT_LIGHT,
  @SerialName("gravity")
  GRAVITY,
  @SerialName("gyroscope")
  GYROSCOPE,
  @SerialName("linear-acceleration")
  LINEAR_ACCELERATION,
  @SerialName("magnetometer")
  MAGNETOMETER,
  @SerialName("relative-orientation")
  RELATIVE_ORIENTATION,
  UNKNOWN,
}
