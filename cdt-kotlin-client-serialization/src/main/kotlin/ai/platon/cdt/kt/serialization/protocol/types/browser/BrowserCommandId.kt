@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.browser

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Browser command ids used by executeBrowserCommand.
 */
@Serializable
public enum class BrowserCommandId {
  @SerialName("openTabSearch")
  OPEN_TAB_SEARCH,
  @SerialName("closeTabSearch")
  CLOSE_TAB_SEARCH,
  UNKNOWN,
}
