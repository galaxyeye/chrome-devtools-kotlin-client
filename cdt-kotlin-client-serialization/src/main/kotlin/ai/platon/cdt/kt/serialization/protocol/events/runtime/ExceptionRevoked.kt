@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.runtime

import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Issued when unhandled exception was revoked.
 */
@Serializable
data class ExceptionRevoked(
  @property:SerialName("reason")
  val reason: String,
  @property:SerialName("exceptionId")
  val exceptionId: Int,
)
