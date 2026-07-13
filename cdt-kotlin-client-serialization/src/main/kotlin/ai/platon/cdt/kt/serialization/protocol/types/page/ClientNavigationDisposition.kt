@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class ClientNavigationDisposition {
  @SerialName("currentTab")
  CURRENT_TAB,
  @SerialName("newTab")
  NEW_TAB,
  @SerialName("newWindow")
  NEW_WINDOW,
  @SerialName("download")
  DOWNLOAD,
  UNKNOWN,
}
