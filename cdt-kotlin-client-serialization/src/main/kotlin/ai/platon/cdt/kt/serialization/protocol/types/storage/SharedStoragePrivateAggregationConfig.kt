@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.storage

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents a dictionary object passed in as privateAggregationConfig to
 * run or selectURL.
 */
@Serializable
data class SharedStoragePrivateAggregationConfig(
  @property:SerialName("aggregationCoordinatorOrigin")
  @param:Optional
  val aggregationCoordinatorOrigin: String? = null,
  @property:SerialName("contextId")
  @param:Optional
  val contextId: String? = null,
  @property:SerialName("filteringIdMaxBytes")
  val filteringIdMaxBytes: Int,
  @property:SerialName("maxContributions")
  @param:Optional
  val maxContributions: Int? = null,
)
