@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.browser
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.Int
import kotlin.String
import kotlin.collections.List

/**
 * Chrome histogram.
 */
@Experimental
@Serializable
data class Histogram(
  @SerialName("name")
  val name: String,
  @SerialName("sum")
  val sum: Int,
  @SerialName("count")
  val count: Int,
  @SerialName("buckets")
  val buckets: List<Bucket>,
)
