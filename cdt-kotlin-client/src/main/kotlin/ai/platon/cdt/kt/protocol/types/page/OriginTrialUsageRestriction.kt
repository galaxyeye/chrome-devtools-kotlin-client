@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.page

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

public enum class OriginTrialUsageRestriction {
  @JsonProperty("None")
  NONE,
  @JsonProperty("Subset")
  SUBSET,
  @JsonEnumDefaultValue
  UNKNOWN,
}
