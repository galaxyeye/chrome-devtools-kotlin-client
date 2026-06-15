@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.memory
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Double
import kotlin.String

/**
 * Executable module information
 */
@Serializable
data class Module(
  @SerialName("name")
  val name: String,
  @SerialName("uuid")
  val uuid: String,
  @SerialName("baseAddress")
  val baseAddress: String,
  @SerialName("size")
  val size: Double,
)
