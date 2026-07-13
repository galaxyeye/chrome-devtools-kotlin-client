@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.performance

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Time domain
 */
@Serializable
public enum class SetTimeDomainTimeDomain {
  @SerialName("timeTicks")
  TIME_TICKS,
  @SerialName("threadTicks")
  THREAD_TICKS,
  UNKNOWN,
}
