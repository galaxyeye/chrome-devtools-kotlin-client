package ai.platon.cdt.kt.protocol.events.page

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.runtime.StackTrace
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Fired when frame has been attached to its parent.
 */
data class FrameAttached(
  @field:JsonProperty("frameId")
  val frameId: String,
  @field:JsonProperty("parentFrameId")
  val parentFrameId: String,
  @field:JsonProperty("stack")
  @param:Optional
  val stack: StackTrace? = null,
)
