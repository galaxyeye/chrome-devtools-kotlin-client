package ai.platon.cdt.kt.protocol.types.indexeddb

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String
import kotlin.collections.List

/**
 * Key path.
 */
public data class KeyPath(
  @field:JsonProperty("type")
  public val type: KeyPathType,
  @field:JsonProperty("string")
  @param:Optional
  public val string: String? = null,
  @field:JsonProperty("array")
  @param:Optional
  public val array: List<String>? = null,
)
