package ai.platon.cdt.kt.protocol.types.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String
import kotlin.collections.List

/**
 * A cookie which was not stored from a response with the corresponding reason.
 */
@Experimental
public data class BlockedSetCookieWithReason(
  @field:JsonProperty("blockedReasons")
  public val blockedReasons: List<SetCookieBlockedReason>,
  @field:JsonProperty("cookieLine")
  public val cookieLine: String,
  @field:JsonProperty("cookie")
  @param:Optional
  public val cookie: Cookie? = null,
)
