package ai.platon.cdt.kt.protocol.types.css

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty

public data class InlineStylesForNode(
  @field:JsonProperty("inlineStyle")
  @param:Optional
  public val inlineStyle: CSSStyle? = null,
  @field:JsonProperty("attributesStyle")
  @param:Optional
  public val attributesStyle: CSSStyle? = null,
)
