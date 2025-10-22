package ai.platon.cdt.kt.protocol.types.profiler

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String

/**
 * Runtime call counter information.
 */
@Experimental
public data class RuntimeCallCounterInfo(
  @field:JsonProperty("name")
  public val name: String,
  @field:JsonProperty("value")
  public val `value`: Double,
  @field:JsonProperty("time")
  public val time: Double,
)
