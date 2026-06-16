@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.network

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * See comments on `net::device_bound_sessions::SessionInclusionRules::UrlRule::rule_type`.
 */
public enum class DeviceBoundSessionUrlRuleRuleType {
  @JsonProperty("Exclude")
  EXCLUDE,
  @JsonProperty("Include")
  INCLUDE,
  @JsonEnumDefaultValue
  UNKNOWN,
}
