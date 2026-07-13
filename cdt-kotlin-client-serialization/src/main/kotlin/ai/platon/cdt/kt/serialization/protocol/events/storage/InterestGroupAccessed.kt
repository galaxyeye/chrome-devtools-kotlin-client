@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.storage

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.storage.InterestGroupAccessType
import kotlin.Double
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * One of the interest groups was accessed. Note that these events are global
 * to all targets sharing an interest group store.
 */
@Serializable
data class InterestGroupAccessed(
  @property:SerialName("accessTime")
  val accessTime: Double,
  @property:SerialName("type")
  val type: InterestGroupAccessType,
  @property:SerialName("ownerOrigin")
  val ownerOrigin: String,
  @property:SerialName("name")
  val name: String,
  @property:SerialName("componentSellerOrigin")
  @param:Optional
  val componentSellerOrigin: String? = null,
  @property:SerialName("bid")
  @param:Optional
  val bid: Double? = null,
  @property:SerialName("bidCurrency")
  @param:Optional
  val bidCurrency: String? = null,
  @property:SerialName("uniqueAuctionId")
  @param:Optional
  val uniqueAuctionId: String? = null,
)
