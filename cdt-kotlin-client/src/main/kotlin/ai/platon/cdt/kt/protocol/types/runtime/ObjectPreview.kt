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
data class ObjectPreview(
  @field:JsonProperty("type")
  val type: ObjectPreviewType,
  @field:JsonProperty("subtype")
  @param:Optional
  val subtype: ObjectPreviewSubtype? = null,
  @field:JsonProperty("description")
  @param:Optional
  val description: String? = null,
  @field:JsonProperty("overflow")
  val overflow: Boolean,
  @field:JsonProperty("properties")
  val properties: List<PropertyPreview>,
  @field:JsonProperty("entries")
  @param:Optional
  val entries: List<EntryPreview>? = null,
)
