@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.page

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.types.page.FrameStartedNavigatingNavigationType
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired when a navigation starts. This event is fired for both
 * renderer-initiated and browser-initiated navigations. For renderer-initiated
 * navigations, the event is fired after `frameRequestedNavigation`.
 * Navigation may still be cancelled after the event is issued. Multiple events
 * can be fired for a single navigation, for example, when a same-document
 * navigation becomes a cross-document navigation (such as in the case of a
 * frameset).
 */
@Serializable
@Experimental
data class FrameStartedNavigating(
  @property:SerialName("frameId")
  val frameId: String,
  @property:SerialName("url")
  val url: String,
  @property:SerialName("loaderId")
  val loaderId: String,
  @property:SerialName("navigationType")
  val navigationType: FrameStartedNavigatingNavigationType,
)
