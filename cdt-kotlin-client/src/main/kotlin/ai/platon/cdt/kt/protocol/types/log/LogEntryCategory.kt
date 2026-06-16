@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.log

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

public enum class LogEntryCategory {
  @JsonProperty("cors")
  CORS,
  @JsonEnumDefaultValue
  UNKNOWN,
}
