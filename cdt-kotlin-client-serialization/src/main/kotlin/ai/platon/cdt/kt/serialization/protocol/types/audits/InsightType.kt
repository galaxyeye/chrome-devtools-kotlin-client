@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents the category of insight that a cookie issue falls under.
 */
@Serializable
public enum class InsightType {
  @SerialName("GitHubResource")
  GIT_HUB_RESOURCE,
  @SerialName("GracePeriod")
  GRACE_PERIOD,
  @SerialName("Heuristics")
  HEURISTICS,
  UNKNOWN,
}
