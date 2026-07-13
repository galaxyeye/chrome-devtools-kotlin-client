@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.network

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.types.network.ReportingApiEndpoint
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Experimental
data class ReportingApiEndpointsChangedForOrigin(
  @property:SerialName("origin")
  val origin: String,
  @property:SerialName("endpoints")
  val endpoints: List<ReportingApiEndpoint>,
)
