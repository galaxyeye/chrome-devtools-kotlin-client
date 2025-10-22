package ai.platon.cdt.kt.protocol.types.browser

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int

/**
 * Chrome histogram bucket.
 */
@Experimental
data class Bucket(
  @field:JsonProperty("low")
  val low: Int,
  @field:JsonProperty("high")
  val high: Int,
  @field:JsonProperty("count")
  val count: Int,
)
