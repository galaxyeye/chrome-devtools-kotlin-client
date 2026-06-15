@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.String

/**
 * Information about the frame affected by an inspector issue.
 */
@Serializable
data class AffectedFrame(
  @SerialName("frameId")
  val frameId: String,
)
