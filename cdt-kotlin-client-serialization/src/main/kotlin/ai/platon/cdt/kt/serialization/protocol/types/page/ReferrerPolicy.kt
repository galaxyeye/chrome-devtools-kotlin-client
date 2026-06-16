@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The referring-policy used for the navigation.
 */
@Serializable
public enum class ReferrerPolicy {
  @SerialName("noReferrer")
  NO_REFERRER,
  @SerialName("noReferrerWhenDowngrade")
  NO_REFERRER_WHEN_DOWNGRADE,
  @SerialName("origin")
  ORIGIN,
  @SerialName("originWhenCrossOrigin")
  ORIGIN_WHEN_CROSS_ORIGIN,
  @SerialName("sameOrigin")
  SAME_ORIGIN,
  @SerialName("strictOrigin")
  STRICT_ORIGIN,
  @SerialName("strictOriginWhenCrossOrigin")
  STRICT_ORIGIN_WHEN_CROSS_ORIGIN,
  @SerialName("unsafeUrl")
  UNSAFE_URL,
  UNKNOWN,
}
