package ai.platon.cdt.kt.protocol.types.runtime

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

@Experimental
public data class PropertyPreview(
  @field:JsonProperty("name")
  public val name: String,
  @field:JsonProperty("type")
  public val type: PropertyPreviewType,
  @field:JsonProperty("value")
  @param:Optional
  public val `value`: String? = null,
  @field:JsonProperty("valuePreview")
  @param:Optional
  public val valuePreview: ObjectPreview? = null,
  @field:JsonProperty("subtype")
  @param:Optional
  public val subtype: PropertyPreviewSubtype? = null,
)
