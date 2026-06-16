@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.memory

import kotlin.Double
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Executable module information
 */
@Serializable
data class Module(
  @property:SerialName("name")
  val name: String,
  @property:SerialName("uuid")
  val uuid: String,
  @property:SerialName("baseAddress")
  val baseAddress: String,
  @property:SerialName("size")
  val size: Double,
)
