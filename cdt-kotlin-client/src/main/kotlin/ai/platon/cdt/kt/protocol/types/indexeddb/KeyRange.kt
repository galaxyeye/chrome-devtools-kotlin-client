package ai.platon.cdt.kt.protocol.types.indexeddb

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean

/**
 * Key range.
 */
public data class KeyRange(
  @field:JsonProperty("lower")
  @param:Optional
  public val lower: Key? = null,
  @field:JsonProperty("upper")
  @param:Optional
  public val upper: Key? = null,
  @field:JsonProperty("lowerOpen")
  public val lowerOpen: Boolean,
  @field:JsonProperty("upperOpen")
  public val upperOpen: Boolean,
)
