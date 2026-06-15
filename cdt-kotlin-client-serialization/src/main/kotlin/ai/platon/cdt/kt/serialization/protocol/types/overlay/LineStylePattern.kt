@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.overlay
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The line pattern (default: solid)
 */
@Serializable
public enum class LineStylePattern {
  @SerialName("dashed")
  DASHED,
  @SerialName("dotted")
  DOTTED,
}
