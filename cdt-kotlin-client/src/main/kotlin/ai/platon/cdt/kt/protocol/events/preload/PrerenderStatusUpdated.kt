@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.preload

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.preload.PreloadingAttemptKey
import ai.platon.cdt.kt.protocol.types.preload.PreloadingStatus
import ai.platon.cdt.kt.protocol.types.preload.PrerenderFinalStatus
import ai.platon.cdt.kt.protocol.types.preload.PrerenderMismatchedHeaders
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String
import kotlin.collections.List

/**
 * Fired when a prerender attempt is updated.
 */
data class PrerenderStatusUpdated(
  @param:JsonProperty("key")
  val key: PreloadingAttemptKey,
  @param:JsonProperty("pipelineId")
  val pipelineId: String,
  @param:JsonProperty("status")
  val status: PreloadingStatus,
  @param:JsonProperty("prerenderStatus")
  @param:Optional
  val prerenderStatus: PrerenderFinalStatus? = null,
  @param:JsonProperty("disallowedMojoInterface")
  @param:Optional
  val disallowedMojoInterface: String? = null,
  @param:JsonProperty("mismatchedHeaders")
  @param:Optional
  val mismatchedHeaders: List<PrerenderMismatchedHeaders>? = null,
)
