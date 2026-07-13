@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.overlay

import ai.platon.cdt.kt.serialization.protocol.types.dom.RGBA
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Configuration data for drawing the source order of an elements children.
 */
@Serializable
data class SourceOrderConfig(
  @property:SerialName("parentOutlineColor")
  val parentOutlineColor: RGBA,
  @property:SerialName("childOutlineColor")
  val childOutlineColor: RGBA,
)
