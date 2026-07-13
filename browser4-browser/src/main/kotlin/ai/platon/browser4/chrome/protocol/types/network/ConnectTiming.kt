@file:Suppress("unused")
package ai.platon.browser4.chrome.protocol.types.network

import ai.platon.browser4.chrome.protocol.support.annotations.Experimental
import kotlin.Double
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Experimental
data class ConnectTiming(
  @property:SerialName("requestTime")
  val requestTime: Double,
)
