package ai.platon.cdt.kt.protocol.types.css

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * CSS keyframe rule representation.
 */
data class CSSKeyframeRule(
  @field:JsonProperty("styleSheetId")
  @param:Optional
  val styleSheetId: String? = null,
  @field:JsonProperty("origin")
  val origin: StyleSheetOrigin,
  @field:JsonProperty("keyText")
  val keyText: Value,
  @field:JsonProperty("style")
  val style: CSSStyle,
)
