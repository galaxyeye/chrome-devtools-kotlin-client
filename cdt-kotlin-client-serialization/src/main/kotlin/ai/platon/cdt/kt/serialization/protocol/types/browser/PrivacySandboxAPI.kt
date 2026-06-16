@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.browser

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class PrivacySandboxAPI {
  @SerialName("BiddingAndAuctionServices")
  BIDDING_AND_AUCTION_SERVICES,
  @SerialName("TrustedKeyValue")
  TRUSTED_KEY_VALUE,
  UNKNOWN,
}
