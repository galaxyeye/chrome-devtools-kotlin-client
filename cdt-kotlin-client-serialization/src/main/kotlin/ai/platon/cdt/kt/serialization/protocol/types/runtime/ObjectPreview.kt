@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.runtime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Boolean
import kotlin.String
import kotlin.collections.List

/**
 * Object containing abbreviated remote object value.
 */
@Experimental
@Serializable
data class ObjectPreview(
  @SerialName("type")
  val type: ObjectPreviewType,
  @SerialName("subtype")
  @param:Optional
  val subtype: ObjectPreviewSubtype? = null,
  @SerialName("description")
  @param:Optional
  val description: String? = null,
  @SerialName("overflow")
  val overflow: Boolean,
  @SerialName("properties")
  val properties: List<PropertyPreview>,
  @SerialName("entries")
  @param:Optional
  val entries: List<EntryPreview>? = null,
)
