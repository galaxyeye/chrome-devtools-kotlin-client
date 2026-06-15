@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.systeminfo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Double
import kotlin.Int
import kotlin.String

/**
 * Represents process info.
 */
@Serializable
data class ProcessInfo(
  @SerialName("type")
  val type: String,
  @SerialName("id")
  val id: Int,
  @SerialName("cpuTime")
  val cpuTime: Double,
)
