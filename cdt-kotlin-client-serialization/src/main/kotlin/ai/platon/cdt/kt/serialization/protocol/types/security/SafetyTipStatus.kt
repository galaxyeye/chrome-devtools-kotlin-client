@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.security
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
@Serializable
public enum class SafetyTipStatus {
  @SerialName("badReputation")
  BAD_REPUTATION,
  @SerialName("lookalike")
  LOOKALIKE,
}
