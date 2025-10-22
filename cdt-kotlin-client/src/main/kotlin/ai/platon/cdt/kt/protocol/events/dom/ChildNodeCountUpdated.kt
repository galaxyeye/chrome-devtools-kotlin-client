package ai.platon.cdt.kt.protocol.events.dom

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int

/**
 * Fired when `Container`'s child node count has changed.
 */
data class ChildNodeCountUpdated(
  @field:JsonProperty("nodeId")
  val nodeId: Int,
  @field:JsonProperty("childNodeCount")
  val childNodeCount: Int,
)
