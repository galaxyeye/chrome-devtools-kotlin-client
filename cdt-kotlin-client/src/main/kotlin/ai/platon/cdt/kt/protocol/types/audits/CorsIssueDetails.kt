package ai.platon.cdt.kt.protocol.types.audits

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.network.ClientSecurityState
import ai.platon.cdt.kt.protocol.types.network.CorsErrorStatus
import ai.platon.cdt.kt.protocol.types.network.IPAddressSpace
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.String

/**
 * Details for a CORS related issue, e.g. a warning or error related to
 * CORS RFC1918 enforcement.
 */
data class CorsIssueDetails(
  @field:JsonProperty("corsErrorStatus")
  val corsErrorStatus: CorsErrorStatus,
  @field:JsonProperty("isWarning")
  val isWarning: Boolean,
  @field:JsonProperty("request")
  val request: AffectedRequest,
  @field:JsonProperty("initiatorOrigin")
  @param:Optional
  val initiatorOrigin: String? = null,
  @field:JsonProperty("resourceIPAddressSpace")
  @param:Optional
  val resourceIPAddressSpace: IPAddressSpace? = null,
  @field:JsonProperty("clientSecurityState")
  @param:Optional
  val clientSecurityState: ClientSecurityState? = null,
)
