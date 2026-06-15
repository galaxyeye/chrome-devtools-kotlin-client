@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.overlay
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.dom.RGBA

/**
 * Style information for drawing a box.
 */
@Serializable
data class BoxStyle(
  @SerialName("fillColor")
  @param:Optional
  val fillColor: RGBA? = null,
  @SerialName("hatchColor")
  @param:Optional
  val hatchColor: RGBA? = null,
)
