@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.storage

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * Bundles the parameters for shared storage access events whose
 * presence/absence can vary according to SharedStorageAccessType.
 */
data class SharedStorageAccessParams(
  @param:JsonProperty("scriptSourceUrl")
  @param:Optional
  val scriptSourceUrl: String? = null,
  @param:JsonProperty("dataOrigin")
  @param:Optional
  val dataOrigin: String? = null,
  @param:JsonProperty("operationName")
  @param:Optional
  val operationName: String? = null,
  @param:JsonProperty("operationId")
  @param:Optional
  val operationId: String? = null,
  @param:JsonProperty("keepAlive")
  @param:Optional
  val keepAlive: Boolean? = null,
  @param:JsonProperty("privateAggregationConfig")
  @param:Optional
  val privateAggregationConfig: SharedStoragePrivateAggregationConfig? = null,
  @param:JsonProperty("serializedData")
  @param:Optional
  val serializedData: String? = null,
  @param:JsonProperty("urlsWithMetadata")
  @param:Optional
  val urlsWithMetadata: List<SharedStorageUrlWithMetadata>? = null,
  @param:JsonProperty("urnUuid")
  @param:Optional
  val urnUuid: String? = null,
  @param:JsonProperty("key")
  @param:Optional
  val key: String? = null,
  @param:JsonProperty("value")
  @param:Optional
  val `value`: String? = null,
  @param:JsonProperty("ignoreIfPresent")
  @param:Optional
  val ignoreIfPresent: Boolean? = null,
  @param:JsonProperty("workletOrdinal")
  @param:Optional
  val workletOrdinal: Int? = null,
  @param:JsonProperty("workletTargetId")
  @param:Optional
  val workletTargetId: String? = null,
  @param:JsonProperty("withLock")
  @param:Optional
  val withLock: String? = null,
  @param:JsonProperty("batchUpdateId")
  @param:Optional
  val batchUpdateId: String? = null,
  @param:JsonProperty("batchSize")
  @param:Optional
  val batchSize: Int? = null,
)
