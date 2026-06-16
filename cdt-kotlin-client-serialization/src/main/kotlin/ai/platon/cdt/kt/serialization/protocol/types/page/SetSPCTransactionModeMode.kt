@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class SetSPCTransactionModeMode {
  @SerialName("none")
  NONE,
  @SerialName("autoAccept")
  AUTO_ACCEPT,
  @SerialName("autoChooseToAuthAnotherWay")
  AUTO_CHOOSE_TO_AUTH_ANOTHER_WAY,
  @SerialName("autoReject")
  AUTO_REJECT,
  @SerialName("autoOptOut")
  AUTO_OPT_OUT,
  UNKNOWN,
}
