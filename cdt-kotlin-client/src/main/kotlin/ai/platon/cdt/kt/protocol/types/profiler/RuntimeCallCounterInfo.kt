package ai.platon.cdt.kt.protocol.types.profiler

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String

/**
 * Runtime call counter information.
 */
@Experimental
data class RuntimeCallCounterInfo(
  @field:JsonProperty("name")
  val name: String,
  @field:JsonProperty("value")
  val `value`: Double,
  @field:JsonProperty("time")
  val time: Double,
)
