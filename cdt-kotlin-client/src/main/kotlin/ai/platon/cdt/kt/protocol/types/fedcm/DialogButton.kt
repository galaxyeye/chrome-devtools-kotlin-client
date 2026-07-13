@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.fedcm

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * The buttons on the FedCM dialog.
 */
public enum class DialogButton {
  @JsonProperty("ConfirmIdpLoginContinue")
  CONFIRM_IDP_LOGIN_CONTINUE,
  @JsonProperty("ErrorGotIt")
  ERROR_GOT_IT,
  @JsonProperty("ErrorMoreDetails")
  ERROR_MORE_DETAILS,
  @JsonEnumDefaultValue
  UNKNOWN,
}
