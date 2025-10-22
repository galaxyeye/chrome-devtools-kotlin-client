package ai.platon.cdt.kt.protocol.types.domsnapshot

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.Int
import kotlin.collections.List

/**
 * Table of details of the post layout rendered text positions. The exact layout should not be
 * regarded as
 * stable and may change between versions.
 */
public data class TextBoxSnapshot(
  @field:JsonProperty("layoutIndex")
  public val layoutIndex: List<Int>,
  @field:JsonProperty("bounds")
  public val bounds: List<List<Double>>,
  @field:JsonProperty("start")
  public val start: List<Int>,
  @field:JsonProperty("length")
  public val length: List<Int>,
)
