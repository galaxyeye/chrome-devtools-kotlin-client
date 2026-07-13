@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * How a device bound session was used during a request.
 */
@Serializable
@Experimental
data class DeviceBoundSessionWithUsage(
  @property:SerialName("sessionKey")
  val sessionKey: DeviceBoundSessionKey,
  @property:SerialName("usage")
  val usage: DeviceBoundSessionWithUsageUsage,
)
