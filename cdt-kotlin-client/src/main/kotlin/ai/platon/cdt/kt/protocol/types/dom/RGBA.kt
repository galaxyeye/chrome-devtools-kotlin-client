package ai.platon.cdt.kt.protocol.types.dom

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.Int

/**
 * A structure holding an RGBA color.
 */
data class RGBA(
  @field:JsonProperty("r")
  val r: Int,
  @field:JsonProperty("g")
  val g: Int,
  @field:JsonProperty("b")
  val b: Int,
  @field:JsonProperty("a")
  @param:Optional
  val a: Double? = null,
)
