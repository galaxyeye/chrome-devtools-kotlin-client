package ai.platon.cdt.kt.protocol.types.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.collections.List

/**
 * A cookie with was not sent with a request with the corresponding reason.
 */
@Experimental
public data class BlockedCookieWithReason(
  @field:JsonProperty("blockedReasons")
  public val blockedReasons: List<CookieBlockedReason>,
  @field:JsonProperty("cookie")
  public val cookie: Cookie,
)
