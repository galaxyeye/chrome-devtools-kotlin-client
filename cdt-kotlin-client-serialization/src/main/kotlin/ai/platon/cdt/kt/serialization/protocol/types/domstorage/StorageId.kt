@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.domstorage

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
  val securityOrigin: String,
  @property:SerialName("isLocalStorage")
  val isLocalStorage: Boolean,
)
