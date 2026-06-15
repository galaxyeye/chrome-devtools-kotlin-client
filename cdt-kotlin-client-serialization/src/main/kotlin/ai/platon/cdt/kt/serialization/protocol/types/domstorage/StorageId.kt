@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.domstorage
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Boolean
import kotlin.String

/**
 * DOM Storage identifier.
 */
@Serializable
data class StorageId(
  @SerialName("securityOrigin")
  val securityOrigin: String,
  @SerialName("isLocalStorage")
  val isLocalStorage: Boolean,
)
