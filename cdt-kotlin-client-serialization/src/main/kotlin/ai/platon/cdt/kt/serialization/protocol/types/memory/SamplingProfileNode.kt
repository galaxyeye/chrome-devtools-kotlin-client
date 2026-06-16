@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.memory

import kotlin.Double
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Heap profile sample.
 */
@Serializable
data class SamplingProfileNode(
  @property:SerialName("size")
  val size: Double,
  @property:SerialName("total")
  val total: Double,
  @property:SerialName("stack")
  val stack: List<String>,
)
