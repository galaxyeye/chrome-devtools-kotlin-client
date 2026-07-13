@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.browser

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Chrome histogram.
 */
@Serializable
@Experimental
data class Histogram(
  @property:SerialName("name")
  val name: String,
  @property:SerialName("sum")
  val sum: Int,
  @property:SerialName("count")
  val count: Int,
  @property:SerialName("buckets")
  val buckets: List<Bucket>,
)
