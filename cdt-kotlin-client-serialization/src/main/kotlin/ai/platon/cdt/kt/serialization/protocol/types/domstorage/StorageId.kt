@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.domstorage

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Boolean
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * DOM Storage identifier.
 */
@Serializable
data class StorageId(
  @property:SerialName("securityOrigin")
  @param:Optional
  val securityOrigin: String? = null,
  @property:SerialName("storageKey")
  @param:Optional
  val storageKey: String? = null,
  @property:SerialName("isLocalStorage")
  val isLocalStorage: Boolean,
)
