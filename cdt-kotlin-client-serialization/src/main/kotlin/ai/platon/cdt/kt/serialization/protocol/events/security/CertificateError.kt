@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.security
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Deprecated
import kotlin.Int
import kotlin.String

/**
 * There is a certificate error. If overriding certificate errors is enabled, then it should be
 * handled with the `handleCertificateError` command. Note: this event does not fire if the
 * certificate error has been allowed internally. Only one client per target should override
 * certificate errors at the same time.
 */
@Deprecated("Deprecated")
@Serializable
data class CertificateError(
  @SerialName("eventId")
  val eventId: Int,
  @SerialName("errorType")
  val errorType: String,
  @SerialName("requestURL")
  val requestURL: String,
)
