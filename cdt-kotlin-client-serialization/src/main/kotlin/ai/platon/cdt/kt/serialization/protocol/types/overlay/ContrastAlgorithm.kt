@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.overlay
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
@Serializable
public enum class ContrastAlgorithm {
  @SerialName("aa")
  AA,
  @SerialName("aaa")
  AAA,
  @SerialName("apca")
  APCA,
}
