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
public data class CorsIssueDetails(
  @field:JsonProperty("corsErrorStatus")
  public val corsErrorStatus: CorsErrorStatus,
  @field:JsonProperty("isWarning")
  public val isWarning: Boolean,
  @field:JsonProperty("request")
  public val request: AffectedRequest,
  @field:JsonProperty("initiatorOrigin")
  @param:Optional
  public val initiatorOrigin: String? = null,
  @field:JsonProperty("resourceIPAddressSpace")
  @param:Optional
  public val resourceIPAddressSpace: IPAddressSpace? = null,
  @field:JsonProperty("clientSecurityState")
  @param:Optional
  public val clientSecurityState: ClientSecurityState? = null,
)
