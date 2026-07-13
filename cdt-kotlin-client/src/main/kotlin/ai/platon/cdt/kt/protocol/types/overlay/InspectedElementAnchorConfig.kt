@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.overlay

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int

data class InspectedElementAnchorConfig(
  @param:JsonProperty("nodeId")
  @param:Optional
  val nodeId: Int? = null,
  @param:JsonProperty("backendNodeId")
  @param:Optional
  val backendNodeId: Int? = null,
)
