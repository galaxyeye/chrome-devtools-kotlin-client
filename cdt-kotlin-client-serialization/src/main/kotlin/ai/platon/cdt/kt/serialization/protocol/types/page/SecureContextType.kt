@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Indicates whether the frame is a secure context and why it is the case.
 */
@Serializable
public enum class SecureContextType {
  @SerialName("Secure")
  SECURE,
  @SerialName("SecureLocalhost")
  SECURE_LOCALHOST,
  @SerialName("InsecureScheme")
  INSECURE_SCHEME,
  @SerialName("InsecureAncestor")
  INSECURE_ANCESTOR,
  UNKNOWN,
}
