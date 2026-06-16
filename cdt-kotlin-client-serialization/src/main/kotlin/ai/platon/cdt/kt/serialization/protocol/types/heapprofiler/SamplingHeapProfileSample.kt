@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.heapprofiler

import kotlin.Double
import kotlin.Int
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A single sample from a sampling profile.
 */
@Serializable
data class SamplingHeapProfileSample(
  @property:SerialName("size")
  val size: Double,
  @property:SerialName("nodeId")
  val nodeId: Int,
  @property:SerialName("ordinal")
  val ordinal: Double,
)
