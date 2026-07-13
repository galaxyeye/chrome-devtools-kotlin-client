@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.storage

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.storage.InterestGroupAuctionEventType
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Any
import kotlin.Double
import kotlin.String
import kotlin.collections.Map

/**
 * An auction involving interest groups is taking place. These events are
 * target-specific.
 */
data class InterestGroupAuctionEventOccurred(
  @param:JsonProperty("eventTime")
  val eventTime: Double,
  @param:JsonProperty("type")
  val type: InterestGroupAuctionEventType,
  @param:JsonProperty("uniqueAuctionId")
  val uniqueAuctionId: String,
  @param:JsonProperty("parentAuctionId")
  @param:Optional
  val parentAuctionId: String? = null,
  @param:JsonProperty("auctionConfig")
  @param:Optional
  val auctionConfig: Map<String, Any?>? = null,
)
