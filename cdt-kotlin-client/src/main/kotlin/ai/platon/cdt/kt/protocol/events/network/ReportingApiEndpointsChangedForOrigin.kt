@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.types.network.ReportingApiEndpoint
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String
import kotlin.collections.List

@Experimental
data class ReportingApiEndpointsChangedForOrigin(
  @param:JsonProperty("origin")
  val origin: String,
  @param:JsonProperty("endpoints")
  val endpoints: List<ReportingApiEndpoint>,
)
