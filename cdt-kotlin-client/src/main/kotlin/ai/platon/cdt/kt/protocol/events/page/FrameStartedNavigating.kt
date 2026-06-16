@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.page

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.types.page.FrameStartedNavigatingNavigationType
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Fired when a navigation starts. This event is fired for both
 * renderer-initiated and browser-initiated navigations. For renderer-initiated
 * navigations, the event is fired after `frameRequestedNavigation`.
 * Navigation may still be cancelled after the event is issued. Multiple events
 * can be fired for a single navigation, for example, when a same-document
 * navigation becomes a cross-document navigation (such as in the case of a
 * frameset).
 */
@Experimental
data class FrameStartedNavigating(
  @param:JsonProperty("frameId")
  val frameId: String,
  @param:JsonProperty("url")
  val url: String,
  @param:JsonProperty("loaderId")
  val loaderId: String,
  @param:JsonProperty("navigationType")
  val navigationType: FrameStartedNavigatingNavigationType,
)
