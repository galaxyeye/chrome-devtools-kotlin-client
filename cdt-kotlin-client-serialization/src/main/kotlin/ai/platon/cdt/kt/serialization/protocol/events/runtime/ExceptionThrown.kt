@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.runtime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.types.runtime.ExceptionDetails
import kotlin.Double

/**
 * Issued when exception was thrown and unhandled.
 */
@Serializable
data class ExceptionThrown(
  @SerialName("timestamp")
  val timestamp: Double,
  @SerialName("exceptionDetails")
  val exceptionDetails: ExceptionDetails,
)
