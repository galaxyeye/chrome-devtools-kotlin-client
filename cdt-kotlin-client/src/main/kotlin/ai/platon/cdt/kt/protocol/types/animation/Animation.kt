package ai.platon.cdt.kt.protocol.types.animation

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.Double
import kotlin.String

/**
 * Animation instance.
 */
public data class Animation(
  @field:JsonProperty("id")
  public val id: String,
  @field:JsonProperty("name")
  public val name: String,
  @field:JsonProperty("pausedState")
  public val pausedState: Boolean,
  @field:JsonProperty("playState")
  public val playState: String,
  @field:JsonProperty("playbackRate")
  public val playbackRate: Double,
  @field:JsonProperty("startTime")
  public val startTime: Double,
  @field:JsonProperty("currentTime")
  public val currentTime: Double,
  @field:JsonProperty("type")
  public val type: AnimationType,
  @field:JsonProperty("source")
  @param:Optional
  public val source: AnimationEffect? = null,
  @field:JsonProperty("cssId")
  @param:Optional
  public val cssId: String? = null,
)
