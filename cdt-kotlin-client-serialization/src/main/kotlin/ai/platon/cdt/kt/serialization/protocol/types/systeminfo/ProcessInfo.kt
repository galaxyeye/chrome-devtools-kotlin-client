@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.systeminfo

import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents process info.
 */
@Serializable
data class ProcessInfo(
  @property:SerialName("type")
  val type: String,
  @property:SerialName("id")
  val id: Int,
  @property:SerialName("cpuTime")
  val cpuTime: Double,
)
