@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int

@Experimental
data class ServiceWorkerRouterInfo(
  @param:JsonProperty("ruleIdMatched")
  @param:Optional
  val ruleIdMatched: Int? = null,
  @param:JsonProperty("matchedSourceType")
  @param:Optional
  val matchedSourceType: ServiceWorkerRouterSource? = null,
  @param:JsonProperty("actualSourceType")
  @param:Optional
  val actualSourceType: ServiceWorkerRouterSource? = null,
)
