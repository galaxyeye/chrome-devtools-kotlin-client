@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.runtime

import ai.platon.cdt.kt.serialization.protocol.types.runtime.ExceptionDetails
import kotlin.Double
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Issued when exception was thrown and unhandled.
 */
@Serializable
data class ExceptionThrown(
  @property:SerialName("timestamp")
  val timestamp: Double,
  @property:SerialName("exceptionDetails")
  val exceptionDetails: ExceptionDetails,
)
