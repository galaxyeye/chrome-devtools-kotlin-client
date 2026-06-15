@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.animation
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Boolean
import kotlin.Double
import kotlin.String

/**
 * Animation instance.
 */
@Serializable
data class Animation(
  @SerialName("id")
  val id: String,
  @SerialName("name")
  val name: String,
  @SerialName("pausedState")
  val pausedState: Boolean,
  @SerialName("playState")
  val playState: String,
  @SerialName("playbackRate")
  val playbackRate: Double,
  @SerialName("startTime")
  val startTime: Double,
  @SerialName("currentTime")
  val currentTime: Double,
  @SerialName("type")
  val type: AnimationType,
  @SerialName("source")
  @param:Optional
  val source: AnimationEffect? = null,
  @SerialName("cssId")
  @param:Optional
  val cssId: String? = null,
)
