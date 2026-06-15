@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.overlay
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.types.dom.RGBA

/**
 * Configuration data for drawing the source order of an elements children.
 */
@Serializable
data class SourceOrderConfig(
  @SerialName("parentOutlineColor")
  val parentOutlineColor: RGBA,
  @SerialName("childOutlineColor")
  val childOutlineColor: RGBA,
)
