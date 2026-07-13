@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Navigation type
 */
@Serializable
public enum class NavigatedWithinDocumentNavigationType {
  @SerialName("fragment")
  FRAGMENT,
  @SerialName("historyApi")
  HISTORY_API,
  @SerialName("other")
  OTHER,
  UNKNOWN,
}
