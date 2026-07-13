@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.runtime

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double

data class HeapUsage(
  @param:JsonProperty("usedSize")
  val usedSize: Double,
  @param:JsonProperty("totalSize")
  val totalSize: Double,
  @param:JsonProperty("embedderHeapUsedSize")
  val embedderHeapUsedSize: Double,
  @param:JsonProperty("backingStorageSize")
  val backingStorageSize: Double,
)
