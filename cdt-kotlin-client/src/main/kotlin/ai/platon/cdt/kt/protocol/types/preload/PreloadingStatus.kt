@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.preload

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * Preloading status values, see also PreloadingTriggeringOutcome. This
 * status is shared by prefetchStatusUpdated and prerenderStatusUpdated.
 */
public enum class PreloadingStatus {
  @JsonProperty("Pending")
  PENDING,
  @JsonProperty("Running")
  RUNNING,
  @JsonProperty("Ready")
  READY,
  @JsonProperty("Success")
  SUCCESS,
  @JsonProperty("Failure")
  FAILURE,
  @JsonProperty("NotSupported")
  NOT_SUPPORTED,
  @JsonEnumDefaultValue
  UNKNOWN,
}
