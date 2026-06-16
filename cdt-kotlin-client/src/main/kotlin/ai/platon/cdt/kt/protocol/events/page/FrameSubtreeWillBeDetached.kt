@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.page

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Fired before frame subtree is detached. Emitted before any frame of the
 * subtree is actually detached.
 */
@Experimental
data class FrameSubtreeWillBeDetached(
  @param:JsonProperty("frameId")
  val frameId: String,
)
