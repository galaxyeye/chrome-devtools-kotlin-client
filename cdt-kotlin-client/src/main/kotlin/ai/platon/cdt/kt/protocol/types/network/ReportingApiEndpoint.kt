@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

@Experimental
data class ReportingApiEndpoint(
  @param:JsonProperty("url")
  val url: String,
  @param:JsonProperty("groupName")
  val groupName: String,
)
