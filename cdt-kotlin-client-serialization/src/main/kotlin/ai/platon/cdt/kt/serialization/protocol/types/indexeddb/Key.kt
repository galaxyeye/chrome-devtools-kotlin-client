@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.indexeddb

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Double
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Key.
 */
@Serializable
data class Key(
  @property:SerialName("type")
  val type: KeyType,
  @property:SerialName("number")
  @param:Optional
  val number: Double? = null,
  @property:SerialName("string")
  @param:Optional
  val string: String? = null,
  @property:SerialName("date")
  @param:Optional
  val date: Double? = null,
  @property:SerialName("array")
  @param:Optional
  val array: List<Key>? = null,
)
