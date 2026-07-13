@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.storage

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Bundles the parameters for shared storage access events whose
 * presence/absence can vary according to SharedStorageAccessType.
 */
@Serializable
data class SharedStorageAccessParams(
  @property:SerialName("scriptSourceUrl")
  @param:Optional
  val scriptSourceUrl: String? = null,
  @property:SerialName("dataOrigin")
  @param:Optional
  val dataOrigin: String? = null,
  @property:SerialName("operationName")
  @param:Optional
  val operationName: String? = null,
  @property:SerialName("operationId")
  @param:Optional
  val operationId: String? = null,
  @property:SerialName("keepAlive")
  @param:Optional
  val keepAlive: Boolean? = null,
  @property:SerialName("privateAggregationConfig")
  @param:Optional
  val privateAggregationConfig: SharedStoragePrivateAggregationConfig? = null,
  @property:SerialName("serializedData")
  @param:Optional
  val serializedData: String? = null,
  @property:SerialName("urlsWithMetadata")
  @param:Optional
  val urlsWithMetadata: List<SharedStorageUrlWithMetadata>? = null,
  @property:SerialName("urnUuid")
  @param:Optional
  val urnUuid: String? = null,
  @property:SerialName("key")
  @param:Optional
  val key: String? = null,
  @property:SerialName("value")
  @param:Optional
  val `value`: String? = null,
  @property:SerialName("ignoreIfPresent")
  @param:Optional
  val ignoreIfPresent: Boolean? = null,
  @property:SerialName("workletOrdinal")
  @param:Optional
  val workletOrdinal: Int? = null,
  @property:SerialName("workletTargetId")
  @param:Optional
  val workletTargetId: String? = null,
  @property:SerialName("withLock")
  @param:Optional
  val withLock: String? = null,
  @property:SerialName("batchUpdateId")
  @param:Optional
  val batchUpdateId: String? = null,
  @property:SerialName("batchSize")
  @param:Optional
  val batchSize: Int? = null,
)
