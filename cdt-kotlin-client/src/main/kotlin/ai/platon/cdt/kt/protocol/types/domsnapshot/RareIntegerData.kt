package ai.platon.cdt.kt.protocol.types.domsnapshot

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.collections.List

public data class RareIntegerData(
  @field:JsonProperty("index")
  public val index: List<Int>,
  @field:JsonProperty("value")
  public val `value`: List<Int>,
)
