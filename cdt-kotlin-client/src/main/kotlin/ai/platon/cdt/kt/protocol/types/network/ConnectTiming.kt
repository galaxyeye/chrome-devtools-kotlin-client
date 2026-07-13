@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double

@Experimental
data class ConnectTiming(
  @param:JsonProperty("requestTime")
  val requestTime: Double,
)
