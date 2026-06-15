@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.runtime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Double

@Serializable
data class HeapUsage(
  @SerialName("usedSize")
  val usedSize: Double,
  @SerialName("totalSize")
  val totalSize: Double,
)
