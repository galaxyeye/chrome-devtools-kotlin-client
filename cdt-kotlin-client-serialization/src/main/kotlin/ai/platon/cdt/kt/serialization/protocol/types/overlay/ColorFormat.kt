@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.overlay
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
@Serializable
public enum class ColorFormat {
  @SerialName("rgb")
  RGB,
  @SerialName("hsl")
  HSL,
  @SerialName("hex")
  HEX,
}
