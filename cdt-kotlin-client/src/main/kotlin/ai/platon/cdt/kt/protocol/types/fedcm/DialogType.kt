@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.fedcm

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * The types of FedCM dialogs.
 */
public enum class DialogType {
  @JsonProperty("AccountChooser")
  ACCOUNT_CHOOSER,
  @JsonProperty("AutoReauthn")
  AUTO_REAUTHN,
  @JsonProperty("ConfirmIdpLogin")
  CONFIRM_IDP_LOGIN,
  @JsonProperty("Error")
  ERROR,
  @JsonEnumDefaultValue
  UNKNOWN,
}
