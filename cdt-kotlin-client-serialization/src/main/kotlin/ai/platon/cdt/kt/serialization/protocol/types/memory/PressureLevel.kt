@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.memory
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Memory pressure level.
 */
@Serializable
public enum class PressureLevel {
  @SerialName("moderate")
  MODERATE,
  @SerialName("critical")
  CRITICAL,
}
