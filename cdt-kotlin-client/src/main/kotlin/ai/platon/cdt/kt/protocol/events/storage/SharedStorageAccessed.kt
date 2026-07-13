@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.storage

import ai.platon.cdt.kt.protocol.types.storage.SharedStorageAccessMethod
import ai.platon.cdt.kt.protocol.types.storage.SharedStorageAccessParams
import ai.platon.cdt.kt.protocol.types.storage.SharedStorageAccessScope
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String

/**
 * Shared storage was accessed by the associated page.
 * The following parameters are included in all events.
 */
data class SharedStorageAccessed(
  @param:JsonProperty("accessTime")
  val accessTime: Double,
  @param:JsonProperty("scope")
  val scope: SharedStorageAccessScope,
  @param:JsonProperty("method")
  val method: SharedStorageAccessMethod,
  @param:JsonProperty("mainFrameId")
  val mainFrameId: String,
  @param:JsonProperty("ownerOrigin")
  val ownerOrigin: String,
  @param:JsonProperty("ownerSite")
  val ownerSite: String,
  @param:JsonProperty("params")
  val params: SharedStorageAccessParams,
)
