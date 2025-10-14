package ai.platon.cdt.kt.protocol.types.dom

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.Int

/**
 * A structure holding an RGBA color.
 */
public data class RGBA(
    @JsonProperty("r")
  public var r: Int,
    @JsonProperty("g")
  public var g: Int,
    @JsonProperty("b")
  public var b: Int,
    @JsonProperty("a")
  @Optional
  public var a: Double? = null,
)
