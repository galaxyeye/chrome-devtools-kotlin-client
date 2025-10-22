package ai.platon.cdt.kt.protocol.types.runtime

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

@Experimental
data class PropertyPreview(
  @field:JsonProperty("name")
  val name: String,
  @field:JsonProperty("type")
  val type: PropertyPreviewType,
  @field:JsonProperty("value")
  @param:Optional
  val `value`: String? = null,
  @field:JsonProperty("valuePreview")
  @param:Optional
  val valuePreview: ObjectPreview? = null,
  @field:JsonProperty("subtype")
  @param:Optional
  val subtype: PropertyPreviewSubtype? = null,
)
