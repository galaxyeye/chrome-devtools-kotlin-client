@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.page

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String
import kotlin.collections.List

@Experimental
data class ShareTarget(
  @param:JsonProperty("action")
  val action: String,
  @param:JsonProperty("method")
  val method: String,
  @param:JsonProperty("enctype")
  val enctype: String,
  @param:JsonProperty("title")
  @param:Optional
  val title: String? = null,
  @param:JsonProperty("text")
  @param:Optional
  val text: String? = null,
  @param:JsonProperty("url")
  @param:Optional
  val url: String? = null,
  @param:JsonProperty("files")
  @param:Optional
  val files: List<FileFilter>? = null,
)
