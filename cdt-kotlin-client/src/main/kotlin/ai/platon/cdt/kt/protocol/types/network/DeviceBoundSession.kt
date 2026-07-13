@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String
import kotlin.collections.List

/**
 * A device bound session.
 */
@Experimental
data class DeviceBoundSession(
  @param:JsonProperty("key")
  val key: DeviceBoundSessionKey,
  @param:JsonProperty("refreshUrl")
  val refreshUrl: String,
  @param:JsonProperty("inclusionRules")
  val inclusionRules: DeviceBoundSessionInclusionRules,
  @param:JsonProperty("cookieCravings")
  val cookieCravings: List<DeviceBoundSessionCookieCraving>,
  @param:JsonProperty("expiryDate")
  val expiryDate: Double,
  @param:JsonProperty("cachedChallenge")
  @param:Optional
  val cachedChallenge: String? = null,
  @param:JsonProperty("allowedRefreshInitiators")
  val allowedRefreshInitiators: List<String>,
)
