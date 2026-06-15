@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.browser
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
@Serializable
public enum class PermissionSetting {
  @SerialName("granted")
  GRANTED,
  @SerialName("denied")
  DENIED,
  @SerialName("prompt")
  PROMPT,
}
