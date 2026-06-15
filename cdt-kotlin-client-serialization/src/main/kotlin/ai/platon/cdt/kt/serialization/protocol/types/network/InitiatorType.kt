@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Type of this initiator.
 */
@Serializable
public enum class InitiatorType {
  @SerialName("parser")
  PARSER,
  @SerialName("script")
  SCRIPT,
  @SerialName("preload")
  PRELOAD,
  @SerialName("SignedExchange")
  SIGNED_EXCHANGE,
  @SerialName("preflight")
  PREFLIGHT,
  @SerialName("other")
  OTHER,
}
