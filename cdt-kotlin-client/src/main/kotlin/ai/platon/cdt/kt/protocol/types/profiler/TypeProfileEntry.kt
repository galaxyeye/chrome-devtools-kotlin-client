package ai.platon.cdt.kt.protocol.types.profiler

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.collections.List

/**
 * Source offset and types for a parameter or return value.
 */
@Experimental
data class TypeProfileEntry(
  @field:JsonProperty("offset")
  val offset: Int,
  @field:JsonProperty("types")
  val types: List<TypeObject>,
)
