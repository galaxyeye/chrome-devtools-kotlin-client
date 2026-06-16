@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.page

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

public enum class FrameStartedNavigatingNavigationType {
  @JsonProperty("reload")
  RELOAD,
  @JsonProperty("reloadBypassingCache")
  RELOAD_BYPASSING_CACHE,
  @JsonProperty("restore")
  RESTORE,
  @JsonProperty("restoreWithPost")
  RESTORE_WITH_POST,
  @JsonProperty("historySameDocument")
  HISTORY_SAME_DOCUMENT,
  @JsonProperty("historyDifferentDocument")
  HISTORY_DIFFERENT_DOCUMENT,
  @JsonProperty("sameDocument")
  SAME_DOCUMENT,
  @JsonProperty("differentDocument")
  DIFFERENT_DOCUMENT,
  @JsonEnumDefaultValue
  UNKNOWN,
}
