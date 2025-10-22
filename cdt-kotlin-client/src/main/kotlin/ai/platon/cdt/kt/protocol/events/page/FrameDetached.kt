package ai.platon.cdt.kt.protocol.events.page

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.types.page.FrameDetachedReason
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Fired when frame has been detached from its parent.
 */
public data class FrameDetached(
  @field:JsonProperty("frameId")
  public val frameId: String,
  @field:JsonProperty("reason")
  @param:Experimental
  public val reason: FrameDetachedReason,
)
