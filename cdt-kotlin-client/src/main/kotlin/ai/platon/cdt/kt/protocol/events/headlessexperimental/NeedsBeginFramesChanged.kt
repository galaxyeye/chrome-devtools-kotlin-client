package ai.platon.cdt.kt.protocol.events.headlessexperimental

import com.fasterxml.jackson.`annotation`.JsonProperty
import java.lang.Deprecated
import kotlin.Boolean

/**
 * Issued when the target starts or stops needing BeginFrames.
 * Deprecated. Issue beginFrame unconditionally instead and use result from
 * beginFrame to detect whether the frames were suppressed.
 */
@Deprecated
data class NeedsBeginFramesChanged(
  @field:JsonProperty("needsBeginFrames")
  val needsBeginFrames: Boolean,
)
