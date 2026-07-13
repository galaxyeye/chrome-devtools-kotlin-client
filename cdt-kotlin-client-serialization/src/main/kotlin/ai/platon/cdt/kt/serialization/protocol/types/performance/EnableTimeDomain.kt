@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.performance

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Time domain to use for collecting and reporting duration metrics.
 */
@Serializable
public enum class EnableTimeDomain {
  @SerialName("timeTicks")
  TIME_TICKS,
  @SerialName("threadTicks")
  THREAD_TICKS,
  UNKNOWN,
}
