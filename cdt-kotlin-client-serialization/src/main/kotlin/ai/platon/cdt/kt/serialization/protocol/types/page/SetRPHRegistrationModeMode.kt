@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class SetRPHRegistrationModeMode {
  @SerialName("none")
  NONE,
  @SerialName("autoAccept")
  AUTO_ACCEPT,
  @SerialName("autoReject")
  AUTO_REJECT,
  UNKNOWN,
}
