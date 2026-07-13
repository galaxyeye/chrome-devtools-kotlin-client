@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.page

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * Navigation type
 */
public enum class NavigatedWithinDocumentNavigationType {
  @JsonProperty("fragment")
  FRAGMENT,
  @JsonProperty("historyApi")
  HISTORY_API,
  @JsonProperty("other")
  OTHER,
  @JsonEnumDefaultValue
  UNKNOWN,
}
