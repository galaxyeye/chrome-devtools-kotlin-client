@file:Suppress("unused")
package ai.platon.browser4.chrome.protocol.types.fetch

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Stages of the request to handle. Request will intercept before the request is
 * sent. Response will intercept after the response is received (but before response
 * body is received).
 */
@Serializable
public enum class RequestStage {
  @SerialName("Request")
  REQUEST,
  @SerialName("Response")
  RESPONSE,
  UNKNOWN,
}
