@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Experimental
data class ShareTarget(
  @property:SerialName("action")
  val action: String,
  @property:SerialName("method")
  val method: String,
  @property:SerialName("enctype")
  val enctype: String,
  @property:SerialName("title")
  @param:Optional
  val title: String? = null,
  @property:SerialName("text")
  @param:Optional
  val text: String? = null,
  @property:SerialName("url")
  @param:Optional
  val url: String? = null,
  @property:SerialName("files")
  @param:Optional
  val files: List<FileFilter>? = null,
)
