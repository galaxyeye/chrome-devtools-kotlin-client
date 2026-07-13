@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.animation

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Animation instance.
 */
@Serializable
data class Animation(
  @property:SerialName("id")
  val id: String,
  @property:SerialName("name")
  val name: String,
  @property:SerialName("pausedState")
  val pausedState: Boolean,
  @property:SerialName("playState")
  val playState: String,
  @property:SerialName("playbackRate")
  val playbackRate: Double,
  @property:SerialName("startTime")
  val startTime: Double,
  @property:SerialName("currentTime")
  val currentTime: Double,
  @property:SerialName("type")
  val type: AnimationType,
  @property:SerialName("source")
  @param:Optional
  val source: AnimationEffect? = null,
  @property:SerialName("cssId")
  @param:Optional
  val cssId: String? = null,
  @property:SerialName("viewOrScrollTimeline")
  @param:Optional
  val viewOrScrollTimeline: ViewOrScrollTimeline? = null,
)
