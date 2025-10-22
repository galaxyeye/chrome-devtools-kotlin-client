package ai.platon.cdt.kt.protocol.types.css

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty

data class InlineStylesForNode(
  @field:JsonProperty("inlineStyle")
  @param:Optional
  val inlineStyle: CSSStyle? = null,
  @field:JsonProperty("attributesStyle")
  @param:Optional
  val attributesStyle: CSSStyle? = null,
)
