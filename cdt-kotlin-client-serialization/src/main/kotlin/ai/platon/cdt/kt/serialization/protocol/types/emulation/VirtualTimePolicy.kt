@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.emulation
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * advance: If the scheduler runs out of immediate work, the virtual time base may fast forward to
 * allow the next delayed task (if any) to run; pause: The virtual time base may not advance;
 * pauseIfNetworkFetchesPending: The virtual time base may not advance if there are any pending
 * resource fetches.
 */
@Serializable
public enum class VirtualTimePolicy {
  @SerialName("advance")
  ADVANCE,
  @SerialName("pause")
  PAUSE,
  @SerialName("pauseIfNetworkFetchesPending")
  PAUSE_IF_NETWORK_FETCHES_PENDING,
}
