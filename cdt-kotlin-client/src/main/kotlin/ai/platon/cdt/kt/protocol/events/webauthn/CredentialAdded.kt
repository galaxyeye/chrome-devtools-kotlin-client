@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.webauthn

import ai.platon.cdt.kt.protocol.types.webauthn.Credential
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Triggered when a credential is added to an authenticator.
 */
data class CredentialAdded(
  @param:JsonProperty("authenticatorId")
  val authenticatorId: String,
  @param:JsonProperty("credential")
  val credential: Credential,
)
