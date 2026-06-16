@file:Suppress("unused")
package ai.platon.browser4.chrome.protocol.types.network

import ai.platon.browser4.chrome.protocol.support.annotations.Experimental
import ai.platon.browser4.chrome.protocol.support.annotations.Optional
import kotlin.Int
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Experimental
data class ServiceWorkerRouterInfo(
  @property:SerialName("ruleIdMatched")
  @param:Optional
  val ruleIdMatched: Int? = null,
  @property:SerialName("matchedSourceType")
  @param:Optional
  val matchedSourceType: ServiceWorkerRouterSource? = null,
  @property:SerialName("actualSourceType")
  @param:Optional
  val actualSourceType: ServiceWorkerRouterSource? = null,
)
