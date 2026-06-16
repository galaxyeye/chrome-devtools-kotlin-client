@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.profiler

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Collected counter information.
 */
@Serializable
@Experimental
data class CounterInfo(
  @property:SerialName("name")
  val name: String,
  @property:SerialName("value")
  val `value`: Int,
)
