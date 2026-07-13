@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.page

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String
import kotlin.collections.List

@Experimental
data class FileFilter(
  @param:JsonProperty("name")
  @param:Optional
  val name: String? = null,
  @param:JsonProperty("accepts")
  @param:Optional
  val accepts: List<String>? = null,
)
