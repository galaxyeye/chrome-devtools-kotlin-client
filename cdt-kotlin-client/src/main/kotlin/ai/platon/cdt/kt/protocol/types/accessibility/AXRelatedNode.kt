package ai.platon.cdt.kt.protocol.types.accessibility

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

data class AXRelatedNode(
  @field:JsonProperty("backendDOMNodeId")
  val backendDOMNodeId: Int,
  @field:JsonProperty("idref")
  @param:Optional
  val idref: String? = null,
  @field:JsonProperty("text")
  @param:Optional
  val text: String? = null,
)
