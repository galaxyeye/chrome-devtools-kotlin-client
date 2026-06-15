@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The referrer policy of the request, as defined in https://www.w3.org/TR/referrer-policy/
 */
@Serializable
public enum class RequestReferrerPolicy {
  @SerialName("unsafe-url")
  UNSAFE_URL,
  @SerialName("no-referrer-when-downgrade")
  NO_REFERRER_WHEN_DOWNGRADE,
  @SerialName("no-referrer")
  NO_REFERRER,
  @SerialName("origin")
  ORIGIN,
  @SerialName("origin-when-cross-origin")
  ORIGIN_WHEN_CROSS_ORIGIN,
  @SerialName("same-origin")
  SAME_ORIGIN,
  @SerialName("strict-origin")
  STRICT_ORIGIN,
  @SerialName("strict-origin-when-cross-origin")
  STRICT_ORIGIN_WHEN_CROSS_ORIGIN,
}
