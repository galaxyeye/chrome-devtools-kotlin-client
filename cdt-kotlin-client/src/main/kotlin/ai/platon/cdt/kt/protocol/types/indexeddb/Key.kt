package ai.platon.cdt.kt.protocol.types.indexeddb

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String
import kotlin.collections.List

/**
 * Key.
 */
public data class Key(
  @field:JsonProperty("type")
  public val type: KeyType,
  @field:JsonProperty("number")
  @param:Optional
  public val number: Double? = null,
  @field:JsonProperty("string")
  @param:Optional
  public val string: String? = null,
  @field:JsonProperty("date")
  @param:Optional
  public val date: Double? = null,
  @field:JsonProperty("array")
  @param:Optional
  public val array: List<Key>? = null,
)
