@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Details for a request that has been blocked with the BLOCKED_BY_RESPONSE
 * code. Currently only used for COEP/COOP, but may be extended to include
 * some CSP errors in the future.
 */
@Serializable
data class BlockedByResponseIssueDetails(
  @property:SerialName("request")
  val request: AffectedRequest,
  @property:SerialName("parentFrame")
  @param:Optional
  val parentFrame: AffectedFrame? = null,
  @property:SerialName("blockedFrame")
  @param:Optional
  val blockedFrame: AffectedFrame? = null,
  @property:SerialName("reason")
  val reason: BlockedByResponseReason,
)
