package ai.platon.cdt.kt.protocol.types.dom

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.Int

/**
 * A structure holding an RGBA color.
 */
public data class RGBA(
  @field:JsonProperty("r")
  public val r: Int,
  @field:JsonProperty("g")
  public val g: Int,
  @field:JsonProperty("b")
  public val b: Int,
  @field:JsonProperty("a")
  @param:Optional
  public val a: Double? = null,
)
