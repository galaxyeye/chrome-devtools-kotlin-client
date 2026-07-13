@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.filesystem

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String
import kotlin.collections.List

data class Directory(
  @param:JsonProperty("name")
  val name: String,
  @param:JsonProperty("nestedDirectories")
  val nestedDirectories: List<String>,
  @param:JsonProperty("nestedFiles")
  val nestedFiles: List<File>,
)
