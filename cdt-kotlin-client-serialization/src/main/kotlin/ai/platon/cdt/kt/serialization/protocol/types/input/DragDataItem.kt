@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.input

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Experimental
data class DragDataItem(
  @property:SerialName("mimeType")
  val mimeType: String,
  @property:SerialName("data")
  val `data`: String,
  @property:SerialName("title")
  @param:Optional
  val title: String? = null,
  @property:SerialName("baseURL")
  @param:Optional
  val baseURL: String? = null,
)
