@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.preload

import ai.platon.cdt.kt.protocol.types.preload.PrefetchStatus
import ai.platon.cdt.kt.protocol.types.preload.PreloadingAttemptKey
import ai.platon.cdt.kt.protocol.types.preload.PreloadingStatus
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Fired when a prefetch attempt is updated.
 */
data class PrefetchStatusUpdated(
  @param:JsonProperty("key")
  val key: PreloadingAttemptKey,
  @param:JsonProperty("pipelineId")
  val pipelineId: String,
  @param:JsonProperty("initiatingFrameId")
  val initiatingFrameId: String,
  @param:JsonProperty("prefetchUrl")
  val prefetchUrl: String,
  @param:JsonProperty("status")
  val status: PreloadingStatus,
  @param:JsonProperty("prefetchStatus")
  val prefetchStatus: PrefetchStatus,
  @param:JsonProperty("requestId")
  val requestId: String,
)
