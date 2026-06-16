@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.storage

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

/**
 * Represents a dictionary object passed in as privateAggregationConfig to
 * run or selectURL.
 */
data class SharedStoragePrivateAggregationConfig(
  @param:JsonProperty("aggregationCoordinatorOrigin")
  @param:Optional
  val aggregationCoordinatorOrigin: String? = null,
  @param:JsonProperty("contextId")
  @param:Optional
  val contextId: String? = null,
  @param:JsonProperty("filteringIdMaxBytes")
  val filteringIdMaxBytes: Int,
  @param:JsonProperty("maxContributions")
  @param:Optional
  val maxContributions: Int? = null,
)
