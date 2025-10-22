package ai.platon.cdt.kt.protocol.types.runtime

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.String
import kotlin.collections.List

/**
 * Object containing abbreviated remote object value.
 */
@Experimental
public data class ObjectPreview(
  @field:JsonProperty("type")
  public val type: ObjectPreviewType,
  @field:JsonProperty("subtype")
  @param:Optional
  public val subtype: ObjectPreviewSubtype? = null,
  @field:JsonProperty("description")
  @param:Optional
  public val description: String? = null,
  @field:JsonProperty("overflow")
  public val overflow: Boolean,
  @field:JsonProperty("properties")
  public val properties: List<PropertyPreview>,
  @field:JsonProperty("entries")
  @param:Optional
  public val entries: List<EntryPreview>? = null,
)
