@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.webauthn

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Triggered when a credential is deleted, e.g. through
 * PublicKeyCredential.signalUnknownCredential().
 */
@Serializable
data class CredentialDeleted(
  @property:SerialName("authenticatorId")
  val authenticatorId: String,
  @property:SerialName("credentialId")
  val credentialId: String,
)
