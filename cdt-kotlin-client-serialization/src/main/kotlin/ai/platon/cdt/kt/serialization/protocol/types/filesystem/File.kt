@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.filesystem

import kotlin.Double
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class File(
  @property:SerialName("name")
  val name: String,
  @property:SerialName("lastModified")
  val lastModified: Double,
  @property:SerialName("size")
  val size: Double,
  @property:SerialName("type")
  val type: String,
)
