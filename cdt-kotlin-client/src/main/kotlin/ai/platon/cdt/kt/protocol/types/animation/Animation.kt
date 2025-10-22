package ai.platon.cdt.kt.protocol.types.animation

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.Double
import kotlin.String

/**
 * Animation instance.
 */
data class Animation(
  @field:JsonProperty("id")
  val id: String,
  @field:JsonProperty("name")
  val name: String,
  @field:JsonProperty("pausedState")
  val pausedState: Boolean,
  @field:JsonProperty("playState")
  val playState: String,
  @field:JsonProperty("playbackRate")
  val playbackRate: Double,
  @field:JsonProperty("startTime")
  val startTime: Double,
  @field:JsonProperty("currentTime")
  val currentTime: Double,
  @field:JsonProperty("type")
  val type: AnimationType,
  @field:JsonProperty("source")
  @param:Optional
  val source: AnimationEffect? = null,
  @field:JsonProperty("cssId")
  @param:Optional
  val cssId: String? = null,
)
