@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.browser

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

public enum class PrivacySandboxAPI {
  @JsonProperty("BiddingAndAuctionServices")
  BIDDING_AND_AUCTION_SERVICES,
  @JsonProperty("TrustedKeyValue")
  TRUSTED_KEY_VALUE,
  @JsonEnumDefaultValue
  UNKNOWN,
}
