@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * Session event details specific to creation.
 */
@Experimental
data class CreationEventDetails(
  @param:JsonProperty("fetchResult")
  val fetchResult: DeviceBoundSessionFetchResult,
  @param:JsonProperty("newSession")
  @param:Optional
  val newSession: DeviceBoundSession? = null,
  @param:JsonProperty("failedRequest")
  @param:Optional
  val failedRequest: DeviceBoundSessionFailedRequest? = null,
)
