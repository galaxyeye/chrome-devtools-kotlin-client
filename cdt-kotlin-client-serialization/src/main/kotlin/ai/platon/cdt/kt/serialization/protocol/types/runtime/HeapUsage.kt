@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.runtime

import kotlin.Double
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HeapUsage(
  @property:SerialName("usedSize")
  val usedSize: Double,
  @property:SerialName("totalSize")
  val totalSize: Double,
  @property:SerialName("embedderHeapUsedSize")
  val embedderHeapUsedSize: Double,
  @property:SerialName("backingStorageSize")
  val backingStorageSize: Double,
)
