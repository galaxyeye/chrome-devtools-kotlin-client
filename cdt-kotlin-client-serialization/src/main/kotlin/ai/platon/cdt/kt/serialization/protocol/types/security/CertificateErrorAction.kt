@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.security

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The action to take when a certificate error occurs. continue will continue processing the
 * request and cancel will cancel the request.
 */
@Serializable
public enum class CertificateErrorAction {
  @SerialName("continue")
  CONTINUE,
  @SerialName("cancel")
  CANCEL,
  UNKNOWN,
}
