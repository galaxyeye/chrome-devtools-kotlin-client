@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.indexeddb
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlin.collections.List

/**
 * Key path.
 */
@Serializable
data class KeyPath(
  @SerialName("type")
  val type: KeyPathType,
  @SerialName("string")
  @param:Optional
  val string: String? = null,
  @SerialName("array")
  @param:Optional
  val array: List<String>? = null,
)
