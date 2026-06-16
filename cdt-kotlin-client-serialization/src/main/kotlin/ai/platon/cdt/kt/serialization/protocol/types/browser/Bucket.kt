@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.browser

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.Int
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Chrome histogram bucket.
 */
@Serializable
@Experimental
data class Bucket(
  @property:SerialName("low")
  val low: Int,
  @property:SerialName("high")
  val high: Int,
  @property:SerialName("count")
  val count: Int,
)
