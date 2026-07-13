@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.overlay

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.dom.RGBA
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Style information for drawing a line.
 */
@Serializable
data class LineStyle(
  @property:SerialName("color")
  @param:Optional
  val color: RGBA? = null,
  @property:SerialName("pattern")
  @param:Optional
  val pattern: LineStylePattern? = null,
)
