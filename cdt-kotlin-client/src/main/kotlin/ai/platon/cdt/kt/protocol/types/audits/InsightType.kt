@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.audits

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * Represents the category of insight that a cookie issue falls under.
 */
public enum class InsightType {
  @JsonProperty("GitHubResource")
  GIT_HUB_RESOURCE,
  @JsonProperty("GracePeriod")
  GRACE_PERIOD,
  @JsonProperty("Heuristics")
  HEURISTICS,
  @JsonEnumDefaultValue
  UNKNOWN,
}
