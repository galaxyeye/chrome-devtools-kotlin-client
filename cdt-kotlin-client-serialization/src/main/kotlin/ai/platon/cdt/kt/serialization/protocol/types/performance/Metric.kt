@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.performance
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Double
import kotlin.String

/**
 * Run-time execution metric.
 */
@Serializable
data class Metric(
  @SerialName("name")
  val name: String,
  @SerialName("value")
  val `value`: Double,
)
