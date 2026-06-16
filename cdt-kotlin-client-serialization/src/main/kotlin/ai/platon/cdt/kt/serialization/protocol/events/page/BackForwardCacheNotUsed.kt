@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.page

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.page.BackForwardCacheNotRestoredExplanation
import ai.platon.cdt.kt.serialization.protocol.types.page.BackForwardCacheNotRestoredExplanationTree
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired for failed bfcache history navigations if BackForwardCache feature is enabled. Do
 * not assume any ordering with the Page.frameNavigated event. This event is fired only for
 * main-frame history navigation where the document changes (non-same-document navigations),
 * when bfcache navigation fails.
 */
@Serializable
@Experimental
data class BackForwardCacheNotUsed(
  @property:SerialName("loaderId")
  val loaderId: String,
  @property:SerialName("frameId")
  val frameId: String,
  @property:SerialName("notRestoredExplanations")
  val notRestoredExplanations: List<BackForwardCacheNotRestoredExplanation>,
  @property:SerialName("notRestoredExplanationsTree")
  @param:Optional
  val notRestoredExplanationsTree: BackForwardCacheNotRestoredExplanationTree? = null,
)
