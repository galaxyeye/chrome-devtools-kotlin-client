@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.log

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class LogEntryCategory {
  @SerialName("cors")
  CORS,
  UNKNOWN,
}
