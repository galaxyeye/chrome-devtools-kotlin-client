@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.webauthn

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Triggered when a credential is deleted, e.g. through
 * PublicKeyCredential.signalUnknownCredential().
 */
data class CredentialDeleted(
  @param:JsonProperty("authenticatorId")
  val authenticatorId: String,
  @param:JsonProperty("credentialId")
  val credentialId: String,
)
