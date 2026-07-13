@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.preload

import ai.platon.cdt.kt.serialization.protocol.types.preload.PreloadingAttemptSource
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Send a list of sources for all preloading attempts in a document.
 */
@Serializable
data class PreloadingAttemptSourcesUpdated(
  @property:SerialName("loaderId")
  val loaderId: String,
  @property:SerialName("preloadingAttemptSources")
  val preloadingAttemptSources: List<PreloadingAttemptSource>,
)
