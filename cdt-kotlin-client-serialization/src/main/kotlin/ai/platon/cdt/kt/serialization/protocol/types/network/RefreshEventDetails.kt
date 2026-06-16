@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Boolean
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Session event details specific to refresh.
 */
@Serializable
@Experimental
data class RefreshEventDetails(
  @property:SerialName("refreshResult")
  val refreshResult: RefreshEventDetailsRefreshResult,
  @property:SerialName("fetchResult")
  @param:Optional
  val fetchResult: DeviceBoundSessionFetchResult? = null,
  @property:SerialName("newSession")
  @param:Optional
  val newSession: DeviceBoundSession? = null,
  @property:SerialName("wasFullyProactiveRefresh")
  val wasFullyProactiveRefresh: Boolean,
  @property:SerialName("failedRequest")
  @param:Optional
  val failedRequest: DeviceBoundSessionFailedRequest? = null,
)
