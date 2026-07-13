@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.domdebugger

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * CSP Violation type.
 */
@Serializable
public enum class CSPViolationType {
  @SerialName("trustedtype-sink-violation")
  TRUSTEDTYPE_SINK_VIOLATION,
  @SerialName("trustedtype-policy-violation")
  TRUSTEDTYPE_POLICY_VIOLATION,
  UNKNOWN,
}
