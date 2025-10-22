package ai.platon.cdt.kt.protocol.types.indexeddb

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double

data class Metadata(
  @field:JsonProperty("entriesCount")
  val entriesCount: Double,
  @field:JsonProperty("keyGeneratorValue")
  val keyGeneratorValue: Double,
)
