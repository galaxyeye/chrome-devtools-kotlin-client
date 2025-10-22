package ai.platon.cdt.kt.protocol.types.domsnapshot

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.collections.List

data class RareIntegerData(
  @field:JsonProperty("index")
  val index: List<Int>,
  @field:JsonProperty("value")
  val `value`: List<Int>,
)
