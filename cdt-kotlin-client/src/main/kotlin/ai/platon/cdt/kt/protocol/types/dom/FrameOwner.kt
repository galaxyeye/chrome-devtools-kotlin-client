package ai.platon.cdt.kt.protocol.types.dom

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int

data class FrameOwner(
  @field:JsonProperty("backendNodeId")
  val backendNodeId: Int,
  @field:JsonProperty("nodeId")
  @param:Optional
  val nodeId: Int? = null,
)
