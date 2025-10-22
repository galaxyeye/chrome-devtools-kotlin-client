package ai.platon.cdt.kt.protocol.types.indexeddb

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String
import kotlin.collections.List

/**
 * Key.
 */
data class Key(
  @field:JsonProperty("type")
  val type: KeyType,
  @field:JsonProperty("number")
  @param:Optional
  val number: Double? = null,
  @field:JsonProperty("string")
  @param:Optional
  val string: String? = null,
  @field:JsonProperty("date")
  @param:Optional
  val date: Double? = null,
  @field:JsonProperty("array")
  @param:Optional
  val array: List<Key>? = null,
)
