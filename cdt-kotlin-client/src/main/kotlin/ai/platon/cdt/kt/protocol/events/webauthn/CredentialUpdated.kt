@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.webauthn

import ai.platon.cdt.kt.protocol.types.webauthn.Credential
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Triggered when a credential is updated, e.g. through
 * PublicKeyCredential.signalCurrentUserDetails().
 */
data class CredentialUpdated(
  @param:JsonProperty("authenticatorId")
  val authenticatorId: String,
  @param:JsonProperty("credential")
  val credential: Credential,
)
