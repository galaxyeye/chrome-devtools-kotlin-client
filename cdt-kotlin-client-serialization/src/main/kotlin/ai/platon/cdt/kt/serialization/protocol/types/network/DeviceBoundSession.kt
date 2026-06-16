@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Double
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A device bound session.
 */
@Serializable
@Experimental
data class DeviceBoundSession(
  @property:SerialName("key")
  val key: DeviceBoundSessionKey,
  @property:SerialName("refreshUrl")
  val refreshUrl: String,
  @property:SerialName("inclusionRules")
  val inclusionRules: DeviceBoundSessionInclusionRules,
  @property:SerialName("cookieCravings")
  val cookieCravings: List<DeviceBoundSessionCookieCraving>,
  @property:SerialName("expiryDate")
  val expiryDate: Double,
  @property:SerialName("cachedChallenge")
  @param:Optional
  val cachedChallenge: String? = null,
  @property:SerialName("allowedRefreshInitiators")
  val allowedRefreshInitiators: List<String>,
)
