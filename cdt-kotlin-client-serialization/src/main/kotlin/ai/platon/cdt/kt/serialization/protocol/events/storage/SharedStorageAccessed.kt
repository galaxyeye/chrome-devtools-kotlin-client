@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.storage

import ai.platon.cdt.kt.serialization.protocol.types.storage.SharedStorageAccessMethod
import ai.platon.cdt.kt.serialization.protocol.types.storage.SharedStorageAccessParams
import ai.platon.cdt.kt.serialization.protocol.types.storage.SharedStorageAccessScope
import kotlin.Double
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Shared storage was accessed by the associated page.
 * The following parameters are included in all events.
 */
@Serializable
data class SharedStorageAccessed(
  @property:SerialName("accessTime")
  val accessTime: Double,
  @property:SerialName("scope")
  val scope: SharedStorageAccessScope,
  @property:SerialName("method")
  val method: SharedStorageAccessMethod,
  @property:SerialName("mainFrameId")
  val mainFrameId: String,
  @property:SerialName("ownerOrigin")
  val ownerOrigin: String,
  @property:SerialName("ownerSite")
  val ownerSite: String,
  @property:SerialName("params")
  val params: SharedStorageAccessParams,
)
