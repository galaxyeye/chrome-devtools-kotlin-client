@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.overlay
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.dom.RGBA

/**
 * Style information for drawing a line.
 */
@Serializable
data class LineStyle(
  @SerialName("color")
  @param:Optional
  val color: RGBA? = null,
  @SerialName("pattern")
  @param:Optional
  val pattern: LineStylePattern? = null,
)
