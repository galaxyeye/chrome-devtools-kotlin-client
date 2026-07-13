@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.fetch

import ai.platon.cdt.kt.serialization.protocol.types.fetch.AuthChallenge
import ai.platon.cdt.kt.serialization.protocol.types.network.Request
import ai.platon.cdt.kt.serialization.protocol.types.network.ResourceType
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Issued when the domain is enabled with handleAuthRequests set to true.
 * The request is paused until client responds with continueWithAuth.
 */
@Serializable
data class AuthRequired(
  @property:SerialName("requestId")
  val requestId: String,
  @property:SerialName("request")
  val request: Request,
  @property:SerialName("frameId")
  val frameId: String,
  @property:SerialName("resourceType")
  val resourceType: ResourceType,
  @property:SerialName("authChallenge")
  val authChallenge: AuthChallenge,
)
