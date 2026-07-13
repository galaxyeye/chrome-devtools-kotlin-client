@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class FrameStartedNavigatingNavigationType {
  @SerialName("reload")
  RELOAD,
  @SerialName("reloadBypassingCache")
  RELOAD_BYPASSING_CACHE,
  @SerialName("restore")
  RESTORE,
  @SerialName("restoreWithPost")
  RESTORE_WITH_POST,
  @SerialName("historySameDocument")
  HISTORY_SAME_DOCUMENT,
  @SerialName("historyDifferentDocument")
  HISTORY_DIFFERENT_DOCUMENT,
  @SerialName("sameDocument")
  SAME_DOCUMENT,
  @SerialName("differentDocument")
  DIFFERENT_DOCUMENT,
  UNKNOWN,
}
