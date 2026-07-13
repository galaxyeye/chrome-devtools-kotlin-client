@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.overlay

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.dom.RGBA
import ai.platon.cdt.kt.serialization.protocol.types.dom.Rect
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Configuration for dual screen hinge
 */
@Serializable
data class HingeConfig(
  @property:SerialName("rect")
  val rect: Rect,
  @property:SerialName("contentColor")
  @param:Optional
  val contentColor: RGBA? = null,
  @property:SerialName("outlineColor")
  @param:Optional
  val outlineColor: RGBA? = null,
)
