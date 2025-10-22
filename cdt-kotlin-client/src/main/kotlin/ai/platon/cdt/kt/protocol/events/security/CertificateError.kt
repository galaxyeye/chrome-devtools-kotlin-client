package ai.platon.cdt.kt.protocol.events.security

import com.fasterxml.jackson.`annotation`.JsonProperty
import java.lang.Deprecated
import kotlin.Int
import kotlin.String

/**
 * There is a certificate error. If overriding certificate errors is enabled, then it should be
 * handled with the `handleCertificateError` command. Note: this event does not fire if the
 * certificate error has been allowed internally. Only one client per target should override
 * certificate errors at the same time.
 */
@Deprecated
data class CertificateError(
  @field:JsonProperty("eventId")
  val eventId: Int,
  @field:JsonProperty("errorType")
  val errorType: String,
  @field:JsonProperty("requestURL")
  val requestURL: String,
)
