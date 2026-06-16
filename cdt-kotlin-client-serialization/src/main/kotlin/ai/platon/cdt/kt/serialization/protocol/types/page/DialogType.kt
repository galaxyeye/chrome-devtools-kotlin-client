@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Javascript dialog type.
 */
@Serializable
public enum class DialogType {
  @SerialName("alert")
  ALERT,
  @SerialName("confirm")
  CONFIRM,
  @SerialName("prompt")
  PROMPT,
  @SerialName("beforeunload")
  BEFOREUNLOAD,
  UNKNOWN,
}
