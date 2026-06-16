@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.fedcm

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The buttons on the FedCM dialog.
 */
@Serializable
public enum class DialogButton {
  @SerialName("ConfirmIdpLoginContinue")
  CONFIRM_IDP_LOGIN_CONTINUE,
  @SerialName("ErrorGotIt")
  ERROR_GOT_IT,
  @SerialName("ErrorMoreDetails")
  ERROR_MORE_DETAILS,
  UNKNOWN,
}
