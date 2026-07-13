@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class PropertyRuleIssueReason {
  @SerialName("InvalidSyntax")
  INVALID_SYNTAX,
  @SerialName("InvalidInitialValue")
  INVALID_INITIAL_VALUE,
  @SerialName("InvalidInherits")
  INVALID_INHERITS,
  @SerialName("InvalidName")
  INVALID_NAME,
  UNKNOWN,
}
