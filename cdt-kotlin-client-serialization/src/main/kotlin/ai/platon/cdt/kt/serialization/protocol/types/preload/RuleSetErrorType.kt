@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.preload

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class RuleSetErrorType {
  @SerialName("SourceIsNotJsonObject")
  SOURCE_IS_NOT_JSON_OBJECT,
  @SerialName("InvalidRulesSkipped")
  INVALID_RULES_SKIPPED,
  @SerialName("InvalidRulesetLevelTag")
  INVALID_RULESET_LEVEL_TAG,
  UNKNOWN,
}
