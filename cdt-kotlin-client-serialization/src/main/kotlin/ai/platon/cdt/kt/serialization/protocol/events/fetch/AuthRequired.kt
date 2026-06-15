@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.fetch
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.types.fetch.AuthChallenge
import ai.platon.cdt.kt.serialization.protocol.types.network.Request
import ai.platon.cdt.kt.serialization.protocol.types.network.ResourceType
import kotlin.String

/**
 * Issued when the domain is enabled with handleAuthRequests set to true.
 * The request is paused until client responds with continueWithAuth.
 */
@Serializable
data class AuthRequired(
  @SerialName("requestId")
  val requestId: String,
  @SerialName("request")
  val request: Request,
  @SerialName("frameId")
  val frameId: String,
  @SerialName("resourceType")
  val resourceType: ResourceType,
  @SerialName("authChallenge")
  val authChallenge: AuthChallenge,
)
