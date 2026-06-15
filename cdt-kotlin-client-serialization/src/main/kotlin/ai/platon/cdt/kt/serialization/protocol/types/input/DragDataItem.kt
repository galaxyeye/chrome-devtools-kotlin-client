@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.input
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String

@Experimental
@Serializable
data class DragDataItem(
  @SerialName("mimeType")
  val mimeType: String,
  @SerialName("data")
  val `data`: String,
  @SerialName("title")
  @param:Optional
  val title: String? = null,
  @SerialName("baseURL")
  @param:Optional
  val baseURL: String? = null,
)
