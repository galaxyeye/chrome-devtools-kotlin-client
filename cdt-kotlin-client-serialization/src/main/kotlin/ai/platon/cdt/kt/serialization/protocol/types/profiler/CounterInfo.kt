@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.profiler
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.Int
import kotlin.String

/**
 * Collected counter information.
 */
@Experimental
@Serializable
data class CounterInfo(
  @SerialName("name")
  val name: String,
  @SerialName("value")
  val `value`: Int,
)
