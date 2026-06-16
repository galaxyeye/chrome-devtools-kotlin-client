@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.preload

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

public enum class RuleSetErrorType {
  @JsonProperty("SourceIsNotJsonObject")
  SOURCE_IS_NOT_JSON_OBJECT,
  @JsonProperty("InvalidRulesSkipped")
  INVALID_RULES_SKIPPED,
  @JsonProperty("InvalidRulesetLevelTag")
  INVALID_RULESET_LEVEL_TAG,
  @JsonEnumDefaultValue
  UNKNOWN,
}
