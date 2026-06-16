@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.webmcp

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents the status of a tool invocation.
 */
@Serializable
public enum class InvocationStatus {
  @SerialName("Completed")
  COMPLETED,
  @SerialName("Canceled")
  CANCELED,
  @SerialName("Error")
  ERROR,
  UNKNOWN,
}
