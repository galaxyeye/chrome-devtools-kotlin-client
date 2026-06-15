@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.profiler
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.Double
import kotlin.String

/**
 * Runtime call counter information.
 */
@Experimental
@Serializable
data class RuntimeCallCounterInfo(
  @SerialName("name")
  val name: String,
  @SerialName("value")
  val `value`: Double,
  @SerialName("time")
  val time: Double,
)
