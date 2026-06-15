@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.overlay
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.dom.RGBA
import ai.platon.cdt.kt.serialization.protocol.types.dom.Rect

/**
 * Configuration for dual screen hinge
 */
@Serializable
data class HingeConfig(
  @SerialName("rect")
  val rect: Rect,
  @SerialName("contentColor")
  @param:Optional
  val contentColor: RGBA? = null,
  @SerialName("outlineColor")
  @param:Optional
  val outlineColor: RGBA? = null,
)
