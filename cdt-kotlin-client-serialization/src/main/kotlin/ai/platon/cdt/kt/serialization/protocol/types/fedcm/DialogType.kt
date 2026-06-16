@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.fedcm

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The types of FedCM dialogs.
 */
@Serializable
public enum class DialogType {
  @SerialName("AccountChooser")
  ACCOUNT_CHOOSER,
  @SerialName("AutoReauthn")
  AUTO_REAUTHN,
  @SerialName("ConfirmIdpLogin")
  CONFIRM_IDP_LOGIN,
  @SerialName("Error")
  ERROR,
  UNKNOWN,
}
