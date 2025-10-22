package ai.platon.cdt.kt.protocol.types.indexeddb

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean

/**
 * Key range.
 */
data class KeyRange(
  @field:JsonProperty("lower")
  @param:Optional
  val lower: Key? = null,
  @field:JsonProperty("upper")
  @param:Optional
  val upper: Key? = null,
  @field:JsonProperty("lowerOpen")
  val lowerOpen: Boolean,
  @field:JsonProperty("upperOpen")
  val upperOpen: Boolean,
)
