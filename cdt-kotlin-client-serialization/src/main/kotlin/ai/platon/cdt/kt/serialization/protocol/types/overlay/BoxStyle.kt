@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.overlay

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.dom.RGBA
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Style information for drawing a box.
 */
@Serializable
data class BoxStyle(
  @property:SerialName("fillColor")
  @param:Optional
  val fillColor: RGBA? = null,
  @property:SerialName("hatchColor")
  @param:Optional
  val hatchColor: RGBA? = null,
)
