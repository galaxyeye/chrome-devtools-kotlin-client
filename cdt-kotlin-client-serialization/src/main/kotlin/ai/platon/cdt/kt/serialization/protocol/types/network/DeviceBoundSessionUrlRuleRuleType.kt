@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * See comments on `net::device_bound_sessions::SessionInclusionRules::UrlRule::rule_type`.
 */
@Serializable
public enum class DeviceBoundSessionUrlRuleRuleType {
  @SerialName("Exclude")
  EXCLUDE,
  @SerialName("Include")
  INCLUDE,
  UNKNOWN,
}
