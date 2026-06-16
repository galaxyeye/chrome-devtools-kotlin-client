@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Target lifecycle state
 */
@Serializable
public enum class SetWebLifecycleStateState {
  @SerialName("frozen")
  FROZEN,
  @SerialName("active")
  ACTIVE,
  UNKNOWN,
}
