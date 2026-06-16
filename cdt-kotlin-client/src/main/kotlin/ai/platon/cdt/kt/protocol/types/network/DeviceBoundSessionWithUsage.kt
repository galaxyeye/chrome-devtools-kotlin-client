@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * How a device bound session was used during a request.
 */
@Experimental
data class DeviceBoundSessionWithUsage(
  @param:JsonProperty("sessionKey")
  val sessionKey: DeviceBoundSessionKey,
  @param:JsonProperty("usage")
  val usage: DeviceBoundSessionWithUsageUsage,
)
