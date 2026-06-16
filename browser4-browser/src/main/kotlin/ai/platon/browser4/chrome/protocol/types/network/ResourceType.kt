@file:Suppress("unused")
package ai.platon.browser4.chrome.protocol.types.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Resource type as it was perceived by the rendering engine.
 */
@Serializable
public enum class ResourceType {
  @SerialName("Document")
  DOCUMENT,
  @SerialName("Stylesheet")
  STYLESHEET,
  @SerialName("Image")
  IMAGE,
  @SerialName("Media")
  MEDIA,
  @SerialName("Font")
  FONT,
  @SerialName("Script")
  SCRIPT,
  @SerialName("TextTrack")
  TEXT_TRACK,
  @SerialName("XHR")
  XHR,
  @SerialName("Fetch")
  FETCH,
  @SerialName("Prefetch")
  PREFETCH,
  @SerialName("EventSource")
  EVENT_SOURCE,
  @SerialName("WebSocket")
  WEB_SOCKET,
  @SerialName("Manifest")
  MANIFEST,
  @SerialName("SignedExchange")
  SIGNED_EXCHANGE,
  @SerialName("Ping")
  PING,
  @SerialName("CSPViolationReport")
  CSP_VIOLATION_REPORT,
  @SerialName("Preflight")
  PREFLIGHT,
  @SerialName("FedCM")
  FED_CM,
  @SerialName("Other")
  OTHER,
  UNKNOWN,
}
