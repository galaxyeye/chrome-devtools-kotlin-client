@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.memory
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Double
import kotlin.String
import kotlin.collections.List

/**
 * Heap profile sample.
 */
@Serializable
data class SamplingProfileNode(
  @SerialName("size")
  val size: Double,
  @SerialName("total")
  val total: Double,
  @SerialName("stack")
  val stack: List<String>,
)
