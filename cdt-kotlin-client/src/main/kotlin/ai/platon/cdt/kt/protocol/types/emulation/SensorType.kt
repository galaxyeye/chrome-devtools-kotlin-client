@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.emulation

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * Used to specify sensor types to emulate.
 * See https://w3c.github.io/sensors/#automation for more information.
 */
public enum class SensorType {
  @JsonProperty("absolute-orientation")
  ABSOLUTE_ORIENTATION,
  @JsonProperty("accelerometer")
  ACCELEROMETER,
  @JsonProperty("ambient-light")
  AMBIENT_LIGHT,
  @JsonProperty("gravity")
  GRAVITY,
  @JsonProperty("gyroscope")
  GYROSCOPE,
  @JsonProperty("linear-acceleration")
  LINEAR_ACCELERATION,
  @JsonProperty("magnetometer")
  MAGNETOMETER,
  @JsonProperty("relative-orientation")
  RELATIVE_ORIENTATION,
  @JsonEnumDefaultValue
  UNKNOWN,
}
