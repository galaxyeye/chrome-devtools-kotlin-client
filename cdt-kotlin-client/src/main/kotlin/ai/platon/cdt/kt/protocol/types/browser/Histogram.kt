package ai.platon.cdt.kt.protocol.types.browser

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * Chrome histogram.
 */
@Experimental
data class Histogram(
  @field:JsonProperty("name")
  val name: String,
  @field:JsonProperty("sum")
  val sum: Int,
  @field:JsonProperty("count")
  val count: Int,
  @field:JsonProperty("buckets")
  val buckets: List<Bucket>,
)
