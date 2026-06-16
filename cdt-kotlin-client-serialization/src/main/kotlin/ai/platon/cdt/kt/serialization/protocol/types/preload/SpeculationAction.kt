@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.preload

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The type of preloading attempted. It corresponds to
 * mojom::SpeculationAction (although PrefetchWithSubresources is omitted as it
 * isn't being used by clients).
 */
@Serializable
public enum class SpeculationAction {
  @SerialName("Prefetch")
  PREFETCH,
  @SerialName("Prerender")
  PRERENDER,
  @SerialName("PrerenderUntilScript")
  PRERENDER_UNTIL_SCRIPT,
  UNKNOWN,
}
