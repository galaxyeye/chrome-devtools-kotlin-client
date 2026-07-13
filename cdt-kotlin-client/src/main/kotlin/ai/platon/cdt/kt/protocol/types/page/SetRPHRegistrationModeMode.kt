@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.page

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

public enum class SetRPHRegistrationModeMode {
  @JsonProperty("none")
  NONE,
  @JsonProperty("autoAccept")
  AUTO_ACCEPT,
  @JsonProperty("autoReject")
  AUTO_REJECT,
  @JsonEnumDefaultValue
  UNKNOWN,
}
