@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.indexeddb

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Key path.
 */
@Serializable
data class KeyPath(
  @property:SerialName("type")
  val type: KeyPathType,
  @property:SerialName("string")
  @param:Optional
  val string: String? = null,
  @property:SerialName("array")
  @param:Optional
  val array: List<String>? = null,
)
