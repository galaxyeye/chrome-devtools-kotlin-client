@file:Suppress("unused")
package ai.platon.browser4.chrome.protocol.types.runtime

import ai.platon.browser4.chrome.protocol.support.annotations.Experimental
import ai.platon.browser4.chrome.protocol.support.annotations.Optional
import kotlin.Boolean
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Object containing abbreviated remote object value.
 */
@Serializable
@Experimental
data class ObjectPreview(
  @property:SerialName("type")
  val type: ObjectPreviewType,
  @property:SerialName("subtype")
  @param:Optional
  val subtype: ObjectPreviewSubtype? = null,
  @property:SerialName("description")
  @param:Optional
  val description: String? = null,
  @property:SerialName("overflow")
  val overflow: Boolean,
  @property:SerialName("properties")
  val properties: List<PropertyPreview>,
  @property:SerialName("entries")
  @param:Optional
  val entries: List<EntryPreview>? = null,
)
