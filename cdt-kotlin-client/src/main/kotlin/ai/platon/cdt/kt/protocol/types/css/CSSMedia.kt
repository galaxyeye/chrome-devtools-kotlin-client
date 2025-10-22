package ai.platon.cdt.kt.protocol.types.css

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String
import kotlin.collections.List

/**
 * CSS media rule descriptor.
 */
data class CSSMedia(
  @field:JsonProperty("text")
  val text: String,
  @field:JsonProperty("source")
  val source: CSSMediaSource,
  @field:JsonProperty("sourceURL")
  @param:Optional
  val sourceURL: String? = null,
  @field:JsonProperty("range")
  @param:Optional
  val range: SourceRange? = null,
  @field:JsonProperty("styleSheetId")
  @param:Optional
  val styleSheetId: String? = null,
  @field:JsonProperty("mediaList")
  @param:Optional
  val mediaList: List<MediaQuery>? = null,
)
