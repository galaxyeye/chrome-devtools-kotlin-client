@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.runtime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String

@Experimental
@Serializable
data class PropertyPreview(
  @SerialName("name")
  val name: String,
  @SerialName("type")
  val type: PropertyPreviewType,
  @SerialName("value")
  @param:Optional
  val `value`: String? = null,
  @SerialName("valuePreview")
  @param:Optional
  val valuePreview: ObjectPreview? = null,
  @SerialName("subtype")
  @param:Optional
  val subtype: PropertyPreviewSubtype? = null,
)
