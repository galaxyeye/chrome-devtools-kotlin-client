@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Session event details specific to creation.
 */
@Serializable
@Experimental
data class CreationEventDetails(
  @property:SerialName("fetchResult")
  val fetchResult: DeviceBoundSessionFetchResult,
  @property:SerialName("newSession")
  @param:Optional
  val newSession: DeviceBoundSession? = null,
  @property:SerialName("failedRequest")
  @param:Optional
  val failedRequest: DeviceBoundSessionFailedRequest? = null,
)
