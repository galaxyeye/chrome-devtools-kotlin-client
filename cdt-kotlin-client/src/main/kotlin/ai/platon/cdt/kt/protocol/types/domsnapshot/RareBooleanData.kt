package ai.platon.cdt.kt.protocol.types.domsnapshot

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.collections.List

data class RareBooleanData(
  @field:JsonProperty("index")
  val index: List<Int>,
)
