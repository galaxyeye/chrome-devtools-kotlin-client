package ai.platon.cdt.kt.protocol.types.browser

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int

/**
 * Browser window bounds information
 */
@Experimental
public data class Bounds(
  @field:JsonProperty("left")
  @param:Optional
  public val left: Int? = null,
  @field:JsonProperty("top")
  @param:Optional
  public val top: Int? = null,
  @field:JsonProperty("width")
  @param:Optional
  public val width: Int? = null,
  @field:JsonProperty("height")
  @param:Optional
  public val height: Int? = null,
  @field:JsonProperty("windowState")
  @param:Optional
  public val windowState: WindowState? = null,
)
