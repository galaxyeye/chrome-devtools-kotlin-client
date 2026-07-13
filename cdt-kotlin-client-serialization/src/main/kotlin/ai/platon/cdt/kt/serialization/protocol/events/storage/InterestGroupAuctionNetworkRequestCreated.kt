@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.storage

import ai.platon.cdt.kt.serialization.protocol.types.storage.InterestGroupAuctionFetchType
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Specifies which auctions a particular network fetch may be related to, and
 * in what role. Note that it is not ordered with respect to
 * Network.requestWillBeSent (but will happen before loadingFinished
 * loadingFailed).
 */
@Serializable
data class InterestGroupAuctionNetworkRequestCreated(
  @property:SerialName("type")
  val type: InterestGroupAuctionFetchType,
  @property:SerialName("requestId")
  val requestId: String,
  @property:SerialName("auctions")
  val auctions: List<String>,
)
