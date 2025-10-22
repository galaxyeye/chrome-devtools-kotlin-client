package ai.platon.cdt.kt.protocol.events.dom

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int

/**
 * Called when shadow root is popped from the element.
 */
@Experimental
data class ShadowRootPopped(
  @field:JsonProperty("hostId")
  val hostId: Int,
  @field:JsonProperty("rootId")
  val rootId: Int,
)
