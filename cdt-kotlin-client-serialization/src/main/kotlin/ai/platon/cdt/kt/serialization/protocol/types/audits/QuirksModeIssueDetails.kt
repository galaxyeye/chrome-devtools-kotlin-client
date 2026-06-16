@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits

import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Details for issues about documents in Quirks Mode
 * or Limited Quirks Mode that affects page layouting.
 */
@Serializable
data class QuirksModeIssueDetails(
  @property:SerialName("isLimitedQuirksMode")
  val isLimitedQuirksMode: Boolean,
  @property:SerialName("documentNodeId")
  val documentNodeId: Int,
  @property:SerialName("url")
  val url: String,
  @property:SerialName("frameId")
  val frameId: String,
  @property:SerialName("loaderId")
  val loaderId: String,
)
