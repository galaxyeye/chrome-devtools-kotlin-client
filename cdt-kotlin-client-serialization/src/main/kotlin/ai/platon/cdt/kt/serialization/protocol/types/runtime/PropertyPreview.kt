@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.runtime

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Experimental
data class PropertyPreview(
  @property:SerialName("name")
  val name: String,
  @property:SerialName("type")
  val type: PropertyPreviewType,
  @property:SerialName("value")
  @param:Optional
  val `value`: String? = null,
  @property:SerialName("valuePreview")
  @param:Optional
  val valuePreview: ObjectPreview? = null,
  @property:SerialName("subtype")
  @param:Optional
  val subtype: PropertyPreviewSubtype? = null,
)
