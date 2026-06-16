@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.preload

import ai.platon.cdt.kt.serialization.protocol.types.preload.PrefetchStatus
import ai.platon.cdt.kt.serialization.protocol.types.preload.PreloadingAttemptKey
import ai.platon.cdt.kt.serialization.protocol.types.preload.PreloadingStatus
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired when a prefetch attempt is updated.
 */
@Serializable
data class PrefetchStatusUpdated(
  @property:SerialName("key")
  val key: PreloadingAttemptKey,
  @property:SerialName("pipelineId")
  val pipelineId: String,
  @property:SerialName("initiatingFrameId")
  val initiatingFrameId: String,
  @property:SerialName("prefetchUrl")
  val prefetchUrl: String,
  @property:SerialName("status")
  val status: PreloadingStatus,
  @property:SerialName("prefetchStatus")
  val prefetchStatus: PrefetchStatus,
  @property:SerialName("requestId")
  val requestId: String,
)
