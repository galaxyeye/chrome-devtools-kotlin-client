@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.storage

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * Enum of network fetches auctions can do.
 */
public enum class InterestGroupAuctionFetchType {
  @JsonProperty("bidderJs")
  BIDDER_JS,
  @JsonProperty("bidderWasm")
  BIDDER_WASM,
  @JsonProperty("sellerJs")
  SELLER_JS,
  @JsonProperty("bidderTrustedSignals")
  BIDDER_TRUSTED_SIGNALS,
  @JsonProperty("sellerTrustedSignals")
  SELLER_TRUSTED_SIGNALS,
  @JsonEnumDefaultValue
  UNKNOWN,
}
