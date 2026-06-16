@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.webauthn

import ai.platon.cdt.kt.serialization.protocol.types.webauthn.Credential
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Triggered when a credential is used in a webauthn assertion.
 */
@Serializable
data class CredentialAsserted(
  @property:SerialName("authenticatorId")
  val authenticatorId: String,
  @property:SerialName("credential")
  val credential: Credential,
)
