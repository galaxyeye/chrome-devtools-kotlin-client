@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.performance

import kotlin.Double
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Run-time execution metric.
 */
@Serializable
data class Metric(
  @property:SerialName("name")
  val name: String,
  @property:SerialName("value")
  val `value`: Double,
)
