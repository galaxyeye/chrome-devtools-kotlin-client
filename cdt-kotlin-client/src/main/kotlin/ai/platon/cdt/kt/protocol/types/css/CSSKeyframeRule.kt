package ai.platon.cdt.kt.protocol.types.css

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * CSS keyframe rule representation.
 */
public data class CSSKeyframeRule(
  @field:JsonProperty("styleSheetId")
  @param:Optional
  public val styleSheetId: String? = null,
  @field:JsonProperty("origin")
  public val origin: StyleSheetOrigin,
  @field:JsonProperty("keyText")
  public val keyText: Value,
  @field:JsonProperty("style")
  public val style: CSSStyle,
)
