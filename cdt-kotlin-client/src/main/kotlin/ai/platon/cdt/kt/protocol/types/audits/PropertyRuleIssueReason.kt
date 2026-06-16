@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.audits

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

public enum class PropertyRuleIssueReason {
  @JsonProperty("InvalidSyntax")
  INVALID_SYNTAX,
  @JsonProperty("InvalidInitialValue")
  INVALID_INITIAL_VALUE,
  @JsonProperty("InvalidInherits")
  INVALID_INHERITS,
  @JsonProperty("InvalidName")
  INVALID_NAME,
  @JsonEnumDefaultValue
  UNKNOWN,
}
