@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.security

import kotlin.Deprecated
import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * There is a certificate error. If overriding certificate errors is enabled, then it should be
 * handled with the `handleCertificateError` command. Note: this event does not fire if the
 * certificate error has been allowed internally. Only one client per target should override
 * certificate errors at the same time.
 */
@Serializable
@Deprecated("Deprecated")
data class CertificateError(
  @property:SerialName("eventId")
  val eventId: Int,
  @property:SerialName("errorType")
  val errorType: String,
  @property:SerialName("requestURL")
  val requestURL: String,
)
