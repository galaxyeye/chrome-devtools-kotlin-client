@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.storage

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.storage.InterestGroupAccessType
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String

/**
 * One of the interest groups was accessed. Note that these events are global
 * to all targets sharing an interest group store.
 */
data class InterestGroupAccessed(
  @param:JsonProperty("accessTime")
  val accessTime: Double,
  @param:JsonProperty("type")
  val type: InterestGroupAccessType,
  @param:JsonProperty("ownerOrigin")
  val ownerOrigin: String,
  @param:JsonProperty("name")
  val name: String,
  @param:JsonProperty("componentSellerOrigin")
  @param:Optional
  val componentSellerOrigin: String? = null,
  @param:JsonProperty("bid")
  @param:Optional
  val bid: Double? = null,
  @param:JsonProperty("bidCurrency")
  @param:Optional
  val bidCurrency: String? = null,
  @param:JsonProperty("uniqueAuctionId")
  @param:Optional
  val uniqueAuctionId: String? = null,
)
