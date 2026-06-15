@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.network.ClientSecurityState
import ai.platon.cdt.kt.serialization.protocol.types.network.CorsErrorStatus
import ai.platon.cdt.kt.serialization.protocol.types.network.IPAddressSpace
import kotlin.Boolean
import kotlin.String

/**
 * Details for a CORS related issue, e.g. a warning or error related to
 * CORS RFC1918 enforcement.
 */
@Serializable
data class CorsIssueDetails(
  @SerialName("corsErrorStatus")
  val corsErrorStatus: CorsErrorStatus,
  @SerialName("isWarning")
  val isWarning: Boolean,
  @SerialName("request")
  val request: AffectedRequest,
  @SerialName("initiatorOrigin")
  @param:Optional
  val initiatorOrigin: String? = null,
  @SerialName("resourceIPAddressSpace")
  @param:Optional
  val resourceIPAddressSpace: IPAddressSpace? = null,
  @SerialName("clientSecurityState")
  @param:Optional
  val clientSecurityState: ClientSecurityState? = null,
)
