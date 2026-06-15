@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.webaudio
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Enum of AudioParam::AutomationRate from the spec
 */
@Serializable
public enum class AutomationRate {
  @SerialName("a-rate")
  A_RATE,
  @SerialName("k-rate")
  K_RATE,
}
