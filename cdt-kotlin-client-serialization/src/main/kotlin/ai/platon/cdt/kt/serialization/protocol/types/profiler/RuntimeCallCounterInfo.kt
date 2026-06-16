@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.profiler

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.Double
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Runtime call counter information.
 */
@Serializable
@Experimental
data class RuntimeCallCounterInfo(
  @property:SerialName("name")
  val name: String,
  @property:SerialName("value")
  val `value`: Double,
  @property:SerialName("time")
  val time: Double,
)
