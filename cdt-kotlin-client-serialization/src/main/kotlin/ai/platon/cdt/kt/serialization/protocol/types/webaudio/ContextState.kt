@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.webaudio
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Enum of AudioContextState from the spec
 */
@Serializable
public enum class ContextState {
  @SerialName("suspended")
  SUSPENDED,
  @SerialName("running")
  RUNNING,
  @SerialName("closed")
  CLOSED,
}
