package ai.platon.cdt.kt.protocol.types.profiler

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

/**
 * Collected counter information.
 */
@Experimental
data class CounterInfo(
  @field:JsonProperty("name")
  val name: String,
  @field:JsonProperty("value")
  val `value`: Int,
)
