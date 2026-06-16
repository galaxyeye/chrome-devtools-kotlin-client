@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.preload

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.preload.PreloadingAttemptKey
import ai.platon.cdt.kt.serialization.protocol.types.preload.PreloadingStatus
import ai.platon.cdt.kt.serialization.protocol.types.preload.PrerenderFinalStatus
import ai.platon.cdt.kt.serialization.protocol.types.preload.PrerenderMismatchedHeaders
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired when a prerender attempt is updated.
 */
@Serializable
data class PrerenderStatusUpdated(
  @property:SerialName("key")
  val key: PreloadingAttemptKey,
  @property:SerialName("pipelineId")
  val pipelineId: String,
  @property:SerialName("status")
  val status: PreloadingStatus,
  @property:SerialName("prerenderStatus")
  @param:Optional
  val prerenderStatus: PrerenderFinalStatus? = null,
  @property:SerialName("disallowedMojoInterface")
  @param:Optional
  val disallowedMojoInterface: String? = null,
  @property:SerialName("mismatchedHeaders")
  @param:Optional
  val mismatchedHeaders: List<PrerenderMismatchedHeaders>? = null,
)
