@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.browser
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.Int

/**
 * Chrome histogram bucket.
 */
@Experimental
@Serializable
data class Bucket(
  @SerialName("low")
  val low: Int,
  @SerialName("high")
  val high: Int,
  @SerialName("count")
  val count: Int,
)
