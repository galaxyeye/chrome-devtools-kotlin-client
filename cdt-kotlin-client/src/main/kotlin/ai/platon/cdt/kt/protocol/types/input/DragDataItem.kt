package ai.platon.cdt.kt.protocol.types.input

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

@Experimental
data class DragDataItem(
  @field:JsonProperty("mimeType")
  val mimeType: String,
  @field:JsonProperty("data")
  val `data`: String,
  @field:JsonProperty("title")
  @param:Optional
  val title: String? = null,
  @field:JsonProperty("baseURL")
  @param:Optional
  val baseURL: String? = null,
)
