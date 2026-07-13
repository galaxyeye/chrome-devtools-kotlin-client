@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.filesystem

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Directory(
  @property:SerialName("name")
  val name: String,
  @property:SerialName("nestedDirectories")
  val nestedDirectories: List<String>,
  @property:SerialName("nestedFiles")
  val nestedFiles: List<File>,
)
