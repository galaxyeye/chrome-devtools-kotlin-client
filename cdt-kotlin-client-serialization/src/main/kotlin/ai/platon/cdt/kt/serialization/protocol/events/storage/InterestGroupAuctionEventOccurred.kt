@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.storage

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.storage.InterestGroupAuctionEventType
import kotlin.Double
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

/**
 * An auction involving interest groups is taking place. These events are
 * target-specific.
 */
@Serializable
data class InterestGroupAuctionEventOccurred(
  @property:SerialName("eventTime")
  val eventTime: Double,
  @property:SerialName("type")
  val type: InterestGroupAuctionEventType,
  @property:SerialName("uniqueAuctionId")
  val uniqueAuctionId: String,
  @property:SerialName("parentAuctionId")
  @param:Optional
  val parentAuctionId: String? = null,
  @property:SerialName("auctionConfig")
  @param:Optional
  val auctionConfig: JsonObject? = null,
)
