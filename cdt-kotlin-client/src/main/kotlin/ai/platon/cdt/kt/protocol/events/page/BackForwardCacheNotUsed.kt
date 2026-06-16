@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.page

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.page.BackForwardCacheNotRestoredExplanation
import ai.platon.cdt.kt.protocol.types.page.BackForwardCacheNotRestoredExplanationTree
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String
import kotlin.collections.List

/**
 * Fired for failed bfcache history navigations if BackForwardCache feature is enabled. Do
 * not assume any ordering with the Page.frameNavigated event. This event is fired only for
 * main-frame history navigation where the document changes (non-same-document navigations),
 * when bfcache navigation fails.
 */
@Experimental
data class BackForwardCacheNotUsed(
  @param:JsonProperty("loaderId")
  val loaderId: String,
  @param:JsonProperty("frameId")
  val frameId: String,
  @param:JsonProperty("notRestoredExplanations")
  val notRestoredExplanations: List<BackForwardCacheNotRestoredExplanation>,
  @param:JsonProperty("notRestoredExplanationsTree")
  @param:Optional
  val notRestoredExplanationsTree: BackForwardCacheNotRestoredExplanationTree? = null,
)
