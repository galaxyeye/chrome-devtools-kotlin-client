@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Network level fetch failure reason.
 */
@Serializable
public enum class ErrorReason {
  @SerialName("Failed")
  FAILED,
  @SerialName("Aborted")
  ABORTED,
  @SerialName("TimedOut")
  TIMED_OUT,
  @SerialName("AccessDenied")
  ACCESS_DENIED,
  @SerialName("ConnectionClosed")
  CONNECTION_CLOSED,
  @SerialName("ConnectionReset")
  CONNECTION_RESET,
  @SerialName("ConnectionRefused")
  CONNECTION_REFUSED,
  @SerialName("ConnectionAborted")
  CONNECTION_ABORTED,
  @SerialName("ConnectionFailed")
  CONNECTION_FAILED,
  @SerialName("NameNotResolved")
  NAME_NOT_RESOLVED,
  @SerialName("InternetDisconnected")
  INTERNET_DISCONNECTED,
  @SerialName("AddressUnreachable")
  ADDRESS_UNREACHABLE,
  @SerialName("BlockedByClient")
  BLOCKED_BY_CLIENT,
  @SerialName("BlockedByResponse")
  BLOCKED_BY_RESPONSE,
}
