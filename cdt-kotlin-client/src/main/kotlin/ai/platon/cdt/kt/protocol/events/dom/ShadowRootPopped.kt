package ai.platon.cdt.kt.protocol.events.dom

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int

/**
 * Called when shadow root is popped from the element.
 */
@Experimental
public data class ShadowRootPopped(
  @field:JsonProperty("hostId")
  public val hostId: Int,
  @field:JsonProperty("rootId")
  public val rootId: Int,
)
