@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.indexeddb
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Double
import kotlin.String
import kotlin.collections.List

/**
 * Key.
 */
@Serializable
data class Key(
  @SerialName("type")
  val type: KeyType,
  @SerialName("number")
  @param:Optional
  val number: Double? = null,
  @SerialName("string")
  @param:Optional
  val string: String? = null,
  @SerialName("date")
  @param:Optional
  val date: Double? = null,
  @SerialName("array")
  @param:Optional
  val array: List<Key>? = null,
)
