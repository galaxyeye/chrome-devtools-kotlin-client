@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.page

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String
import kotlin.collections.List

@Experimental
data class FileHandler(
  @param:JsonProperty("action")
  val action: String,
  @param:JsonProperty("name")
  val name: String,
  @param:JsonProperty("icons")
  @param:Optional
  val icons: List<ImageResource>? = null,
  @param:JsonProperty("accepts")
  @param:Optional
  val accepts: List<FileFilter>? = null,
  @param:JsonProperty("launchType")
  val launchType: String,
)
