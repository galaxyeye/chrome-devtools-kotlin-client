@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.preload

import ai.platon.cdt.kt.protocol.types.preload.PreloadingAttemptSource
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String
import kotlin.collections.List

/**
 * Send a list of sources for all preloading attempts in a document.
 */
data class PreloadingAttemptSourcesUpdated(
  @param:JsonProperty("loaderId")
  val loaderId: String,
  @param:JsonProperty("preloadingAttemptSources")
  val preloadingAttemptSources: List<PreloadingAttemptSource>,
)
