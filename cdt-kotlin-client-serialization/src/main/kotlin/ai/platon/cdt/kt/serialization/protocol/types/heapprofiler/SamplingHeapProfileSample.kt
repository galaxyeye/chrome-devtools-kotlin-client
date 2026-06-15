@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.heapprofiler
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Double
import kotlin.Int

/**
 * A single sample from a sampling profile.
 */
@Serializable
data class SamplingHeapProfileSample(
  @SerialName("size")
  val size: Double,
  @SerialName("nodeId")
  val nodeId: Int,
  @SerialName("ordinal")
  val ordinal: Double,
)
