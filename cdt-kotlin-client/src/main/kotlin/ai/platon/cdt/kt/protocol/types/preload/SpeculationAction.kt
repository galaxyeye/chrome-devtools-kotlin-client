@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.preload

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * The type of preloading attempted. It corresponds to
 * mojom::SpeculationAction (although PrefetchWithSubresources is omitted as it
 * isn't being used by clients).
 */
public enum class SpeculationAction {
  @JsonProperty("Prefetch")
  PREFETCH,
  @JsonProperty("Prerender")
  PRERENDER,
  @JsonProperty("PrerenderUntilScript")
  PRERENDER_UNTIL_SCRIPT,
  @JsonEnumDefaultValue
  UNKNOWN,
}
