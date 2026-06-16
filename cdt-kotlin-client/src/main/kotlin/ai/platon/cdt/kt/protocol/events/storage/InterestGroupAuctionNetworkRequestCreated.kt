@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.storage

import ai.platon.cdt.kt.protocol.types.storage.InterestGroupAuctionFetchType
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String
import kotlin.collections.List

/**
 * Specifies which auctions a particular network fetch may be related to, and
 * in what role. Note that it is not ordered with respect to
 * Network.requestWillBeSent (but will happen before loadingFinished
 * loadingFailed).
 */
data class InterestGroupAuctionNetworkRequestCreated(
  @param:JsonProperty("type")
  val type: InterestGroupAuctionFetchType,
  @param:JsonProperty("requestId")
  val requestId: String,
  @param:JsonProperty("auctions")
  val auctions: List<String>,
)
