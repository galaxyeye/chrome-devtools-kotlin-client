package ai.platon.cdt.kt.protocol.types.domsnapshot

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.collections.List

/**
 * Data that is only present on rare nodes.
 */
data class RareStringData(
  @field:JsonProperty("index")
  val index: List<Int>,
  @field:JsonProperty("value")
  val `value`: List<Int>,
)
