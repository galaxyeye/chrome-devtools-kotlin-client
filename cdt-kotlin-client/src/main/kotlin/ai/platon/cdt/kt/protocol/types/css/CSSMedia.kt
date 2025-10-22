package ai.platon.cdt.kt.protocol.types.css

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String
import kotlin.collections.List

/**
 * CSS media rule descriptor.
 */
public data class CSSMedia(
  @field:JsonProperty("text")
  public val text: String,
  @field:JsonProperty("source")
  public val source: CSSMediaSource,
  @field:JsonProperty("sourceURL")
  @param:Optional
  public val sourceURL: String? = null,
  @field:JsonProperty("range")
  @param:Optional
  public val range: SourceRange? = null,
  @field:JsonProperty("styleSheetId")
  @param:Optional
  public val styleSheetId: String? = null,
  @field:JsonProperty("mediaList")
  @param:Optional
  public val mediaList: List<MediaQuery>? = null,
)
