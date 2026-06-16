@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Information about the frame affected by an inspector issue.
 */
@Serializable
data class AffectedFrame(
  @property:SerialName("frameId")
  val frameId: String,
)
