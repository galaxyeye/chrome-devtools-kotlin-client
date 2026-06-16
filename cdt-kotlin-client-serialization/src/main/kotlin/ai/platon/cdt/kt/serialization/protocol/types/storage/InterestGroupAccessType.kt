@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.storage

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Enum of interest group access types.
 */
@Serializable
public enum class InterestGroupAccessType {
  @SerialName("join")
  JOIN,
  @SerialName("leave")
  LEAVE,
  @SerialName("update")
  UPDATE,
  @SerialName("loaded")
  LOADED,
  @SerialName("bid")
  BID,
  @SerialName("win")
  WIN,
  @SerialName("additionalBid")
  ADDITIONAL_BID,
  @SerialName("additionalBidWin")
  ADDITIONAL_BID_WIN,
  @SerialName("topLevelBid")
  TOP_LEVEL_BID,
  @SerialName("topLevelAdditionalBid")
  TOP_LEVEL_ADDITIONAL_BID,
  @SerialName("clear")
  CLEAR,
  UNKNOWN,
}
