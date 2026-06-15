@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Stages of the interception to begin intercepting. Request will intercept before the request is
 * sent. Response will intercept after the response is received.
 */
@Serializable
public enum class InterceptionStage {
  @SerialName("Request")
  REQUEST,
  @SerialName("HeadersReceived")
  HEADERS_RECEIVED,
}
