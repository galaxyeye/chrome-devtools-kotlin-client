@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.smartcardemulation

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * Indicates the PC/SC error code.
 *
 * This maps to:
 * PC/SC Lite: https://pcsclite.apdu.fr/api/group__ErrorCodes.html
 * Microsoft: https://learn.microsoft.com/en-us/windows/win32/secauthn/authentication-return-values
 */
public enum class ResultCode {
  @JsonProperty("success")
  SUCCESS,
  @JsonProperty("removed-card")
  REMOVED_CARD,
  @JsonProperty("reset-card")
  RESET_CARD,
  @JsonProperty("unpowered-card")
  UNPOWERED_CARD,
  @JsonProperty("unresponsive-card")
  UNRESPONSIVE_CARD,
  @JsonProperty("unsupported-card")
  UNSUPPORTED_CARD,
  @JsonProperty("reader-unavailable")
  READER_UNAVAILABLE,
  @JsonProperty("sharing-violation")
  SHARING_VIOLATION,
  @JsonProperty("not-transacted")
  NOT_TRANSACTED,
  @JsonProperty("no-smartcard")
  NO_SMARTCARD,
  @JsonProperty("proto-mismatch")
  PROTO_MISMATCH,
  @JsonProperty("system-cancelled")
  SYSTEM_CANCELLED,
  @JsonProperty("not-ready")
  NOT_READY,
  @JsonProperty("cancelled")
  CANCELLED,
  @JsonProperty("insufficient-buffer")
  INSUFFICIENT_BUFFER,
  @JsonProperty("invalid-handle")
  INVALID_HANDLE,
  @JsonProperty("invalid-parameter")
  INVALID_PARAMETER,
  @JsonProperty("invalid-value")
  INVALID_VALUE,
  @JsonProperty("no-memory")
  NO_MEMORY,
  @JsonProperty("timeout")
  TIMEOUT,
  @JsonProperty("unknown-reader")
  UNKNOWN_READER,
  @JsonProperty("unsupported-feature")
  UNSUPPORTED_FEATURE,
  @JsonProperty("no-readers-available")
  NO_READERS_AVAILABLE,
  @JsonProperty("service-stopped")
  SERVICE_STOPPED,
  @JsonProperty("no-service")
  NO_SERVICE,
  @JsonProperty("comm-error")
  COMM_ERROR,
  @JsonProperty("internal-error")
  INTERNAL_ERROR,
  @JsonProperty("server-too-busy")
  SERVER_TOO_BUSY,
  @JsonProperty("unexpected")
  UNEXPECTED,
  @JsonProperty("shutdown")
  SHUTDOWN,
  @JsonProperty("unknown-card")
  UNKNOWN_CARD,
  @JsonProperty("unknown")
  @JsonEnumDefaultValue
  UNKNOWN,
}
