@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean

/**
 * Session event details specific to refresh.
 */
@Experimental
data class RefreshEventDetails(
  @param:JsonProperty("refreshResult")
  val refreshResult: RefreshEventDetailsRefreshResult,
  @param:JsonProperty("fetchResult")
  @param:Optional
  val fetchResult: DeviceBoundSessionFetchResult? = null,
  @param:JsonProperty("newSession")
  @param:Optional
  val newSession: DeviceBoundSession? = null,
  @param:JsonProperty("wasFullyProactiveRefresh")
  val wasFullyProactiveRefresh: Boolean,
  @param:JsonProperty("failedRequest")
  @param:Optional
  val failedRequest: DeviceBoundSessionFailedRequest? = null,
)
