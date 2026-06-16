@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class HeavyAdResolutionStatus {
  @SerialName("HeavyAdBlocked")
  HEAVY_AD_BLOCKED,
  @SerialName("HeavyAdWarning")
  HEAVY_AD_WARNING,
  UNKNOWN,
}
