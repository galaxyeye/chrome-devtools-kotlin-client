@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.storage

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Enum of network fetches auctions can do.
 */
@Serializable
public enum class InterestGroupAuctionFetchType {
  @SerialName("bidderJs")
  BIDDER_JS,
  @SerialName("bidderWasm")
  BIDDER_WASM,
  @SerialName("sellerJs")
  SELLER_JS,
  @SerialName("bidderTrustedSignals")
  BIDDER_TRUSTED_SIGNALS,
  @SerialName("sellerTrustedSignals")
  SELLER_TRUSTED_SIGNALS,
  UNKNOWN,
}
