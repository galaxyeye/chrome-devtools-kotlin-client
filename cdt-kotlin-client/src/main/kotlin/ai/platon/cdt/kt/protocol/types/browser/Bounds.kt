package ai.platon.cdt.kt.protocol.types.browser

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int

/**
 * Browser window bounds information
 */
@Experimental
data class Bounds(
  @field:JsonProperty("left")
  @param:Optional
  val left: Int? = null,
  @field:JsonProperty("top")
  @param:Optional
  val top: Int? = null,
  @field:JsonProperty("width")
  @param:Optional
  val width: Int? = null,
  @field:JsonProperty("height")
  @param:Optional
  val height: Int? = null,
  @field:JsonProperty("windowState")
  @param:Optional
  val windowState: WindowState? = null,
)
