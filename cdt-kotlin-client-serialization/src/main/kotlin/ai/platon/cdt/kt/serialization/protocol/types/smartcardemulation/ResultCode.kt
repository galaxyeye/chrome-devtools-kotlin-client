@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.smartcardemulation

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Indicates the PC/SC error code.
 *
 * This maps to:
 * PC/SC Lite: https://pcsclite.apdu.fr/api/group__ErrorCodes.html
 * Microsoft: https://learn.microsoft.com/en-us/windows/win32/secauthn/authentication-return-values
 */
@Serializable
public enum class ResultCode {
  @SerialName("success")
  SUCCESS,
  @SerialName("removed-card")
  REMOVED_CARD,
  @SerialName("reset-card")
  RESET_CARD,
  @SerialName("unpowered-card")
  UNPOWERED_CARD,
  @SerialName("unresponsive-card")
  UNRESPONSIVE_CARD,
  @SerialName("unsupported-card")
  UNSUPPORTED_CARD,
  @SerialName("reader-unavailable")
  READER_UNAVAILABLE,
  @SerialName("sharing-violation")
  SHARING_VIOLATION,
  @SerialName("not-transacted")
  NOT_TRANSACTED,
  @SerialName("no-smartcard")
  NO_SMARTCARD,
  @SerialName("proto-mismatch")
  PROTO_MISMATCH,
  @SerialName("system-cancelled")
  SYSTEM_CANCELLED,
  @SerialName("not-ready")
  NOT_READY,
  @SerialName("cancelled")
  CANCELLED,
  @SerialName("insufficient-buffer")
  INSUFFICIENT_BUFFER,
  @SerialName("invalid-handle")
  INVALID_HANDLE,
  @SerialName("invalid-parameter")
  INVALID_PARAMETER,
  @SerialName("invalid-value")
  INVALID_VALUE,
  @SerialName("no-memory")
  NO_MEMORY,
  @SerialName("timeout")
  TIMEOUT,
  @SerialName("unknown-reader")
  UNKNOWN_READER,
  @SerialName("unsupported-feature")
  UNSUPPORTED_FEATURE,
  @SerialName("no-readers-available")
  NO_READERS_AVAILABLE,
  @SerialName("service-stopped")
  SERVICE_STOPPED,
  @SerialName("no-service")
  NO_SERVICE,
  @SerialName("comm-error")
  COMM_ERROR,
  @SerialName("internal-error")
  INTERNAL_ERROR,
  @SerialName("server-too-busy")
  SERVER_TOO_BUSY,
  @SerialName("unexpected")
  UNEXPECTED,
  @SerialName("shutdown")
  SHUTDOWN,
  @SerialName("unknown-card")
  UNKNOWN_CARD,
  @SerialName("unknown")
  UNKNOWN,
}
