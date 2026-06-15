@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
@Serializable
public enum class ContentSecurityPolicyViolationType {
  @SerialName("kInlineViolation")
  K_INLINE_VIOLATION,
  @SerialName("kEvalViolation")
  K_EVAL_VIOLATION,
  @SerialName("kURLViolation")
  K_URL_VIOLATION,
  @SerialName("kTrustedTypesSinkViolation")
  K_TRUSTED_TYPES_SINK_VIOLATION,
  @SerialName("kTrustedTypesPolicyViolation")
  K_TRUSTED_TYPES_POLICY_VIOLATION,
}
