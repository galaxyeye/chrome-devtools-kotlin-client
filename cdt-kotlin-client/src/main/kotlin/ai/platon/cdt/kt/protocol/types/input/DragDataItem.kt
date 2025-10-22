package ai.platon.cdt.kt.protocol.types.input

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

@Experimental
public data class DragDataItem(
  @field:JsonProperty("mimeType")
  public val mimeType: String,
  @field:JsonProperty("data")
  public val `data`: String,
  @field:JsonProperty("title")
  @param:Optional
  public val title: String? = null,
  @field:JsonProperty("baseURL")
  @param:Optional
  public val baseURL: String? = null,
)
