@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.preload

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Preloading status values, see also PreloadingTriggeringOutcome. This
 * status is shared by prefetchStatusUpdated and prerenderStatusUpdated.
 */
@Serializable
public enum class PreloadingStatus {
  @SerialName("Pending")
  PENDING,
  @SerialName("Running")
  RUNNING,
  @SerialName("Ready")
  READY,
  @SerialName("Success")
  SUCCESS,
  @SerialName("Failure")
  FAILURE,
  @SerialName("NotSupported")
  NOT_SUPPORTED,
  UNKNOWN,
}
