@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.page

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

public enum class SetSPCTransactionModeMode {
  @JsonProperty("none")
  NONE,
  @JsonProperty("autoAccept")
  AUTO_ACCEPT,
  @JsonProperty("autoChooseToAuthAnotherWay")
  AUTO_CHOOSE_TO_AUTH_ANOTHER_WAY,
  @JsonProperty("autoReject")
  AUTO_REJECT,
  @JsonProperty("autoOptOut")
  AUTO_OPT_OUT,
  @JsonEnumDefaultValue
  UNKNOWN,
}
