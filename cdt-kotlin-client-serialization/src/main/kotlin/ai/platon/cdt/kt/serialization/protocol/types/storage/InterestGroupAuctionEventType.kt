@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.storage

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Enum of auction events.
 */
@Serializable
public enum class InterestGroupAuctionEventType {
  @SerialName("started")
  STARTED,
  @SerialName("configResolved")
  CONFIG_RESOLVED,
  UNKNOWN,
}
