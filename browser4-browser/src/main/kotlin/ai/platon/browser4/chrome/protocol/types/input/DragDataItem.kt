@file:Suppress("unused")
package ai.platon.browser4.chrome.protocol.types.input

import ai.platon.browser4.chrome.protocol.support.annotations.Experimental
import ai.platon.browser4.chrome.protocol.support.annotations.Optional
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
