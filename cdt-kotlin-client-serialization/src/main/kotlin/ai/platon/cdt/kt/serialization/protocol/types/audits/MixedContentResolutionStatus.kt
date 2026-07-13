@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class MixedContentResolutionStatus {
  @SerialName("MixedContentBlocked")
  MIXED_CONTENT_BLOCKED,
  @SerialName("MixedContentAutomaticallyUpgraded")
  MIXED_CONTENT_AUTOMATICALLY_UPGRADED,
  @SerialName("MixedContentWarning")
  MIXED_CONTENT_WARNING,
  UNKNOWN,
}
