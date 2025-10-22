package ai.platon.cdt.kt.protocol.types.indexeddb

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double

public data class Metadata(
  @field:JsonProperty("entriesCount")
  public val entriesCount: Double,
  @field:JsonProperty("keyGeneratorValue")
  public val keyGeneratorValue: Double,
)
