package ai.platon.cdt.kt.protocol.events.fetch

import ai.platon.cdt.kt.protocol.types.fetch.AuthChallenge
import ai.platon.cdt.kt.protocol.types.network.Request
import ai.platon.cdt.kt.protocol.types.network.ResourceType
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Issued when the domain is enabled with handleAuthRequests set to true.
 * The request is paused until client responds with continueWithAuth.
 */
data class AuthRequired(
  @field:JsonProperty("requestId")
  val requestId: String,
  @field:JsonProperty("request")
  val request: Request,
  @field:JsonProperty("frameId")
  val frameId: String,
  @field:JsonProperty("resourceType")
  val resourceType: ResourceType,
  @field:JsonProperty("authChallenge")
  val authChallenge: AuthChallenge,
)
