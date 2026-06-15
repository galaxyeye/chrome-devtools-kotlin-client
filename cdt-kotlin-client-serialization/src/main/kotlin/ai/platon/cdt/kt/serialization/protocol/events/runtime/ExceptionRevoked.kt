@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.runtime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Int
import kotlin.String

/**
 * Issued when unhandled exception was revoked.
 */
@Serializable
data class ExceptionRevoked(
  @SerialName("reason")
  val reason: String,
  @SerialName("exceptionId")
  val exceptionId: Int,
)
