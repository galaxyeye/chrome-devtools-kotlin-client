package ai.platon.cdt.kt.protocol.types.accessibility

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

public data class AXRelatedNode(
  @field:JsonProperty("backendDOMNodeId")
  public val backendDOMNodeId: Int,
  @field:JsonProperty("idref")
  @param:Optional
  public val idref: String? = null,
  @field:JsonProperty("text")
  @param:Optional
  public val text: String? = null,
)
