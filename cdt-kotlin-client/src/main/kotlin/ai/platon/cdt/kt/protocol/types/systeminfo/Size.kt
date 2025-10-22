package ai.platon.cdt.kt.protocol.types.systeminfo

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int

/**
 * Describes the width and height dimensions of an entity.
 */
data class Size(
  @field:JsonProperty("width")
  val width: Int,
  @field:JsonProperty("height")
  val height: Int,
)
