@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.filesystem

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String

data class File(
  @param:JsonProperty("name")
  val name: String,
  @param:JsonProperty("lastModified")
  val lastModified: Double,
  @param:JsonProperty("size")
  val size: Double,
  @param:JsonProperty("type")
  val type: String,
)
