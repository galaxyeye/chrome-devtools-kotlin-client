@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.log

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Violation type.
 */
@Serializable
public enum class ViolationSettingName {
  @SerialName("longTask")
  LONG_TASK,
  @SerialName("longLayout")
  LONG_LAYOUT,
  @SerialName("blockedEvent")
  BLOCKED_EVENT,
  @SerialName("blockedParser")
  BLOCKED_PARSER,
  @SerialName("discouragedAPIUse")
  DISCOURAGED_API_USE,
  @SerialName("handler")
  HANDLER,
  @SerialName("recurringHandler")
  RECURRING_HANDLER,
  UNKNOWN,
}
