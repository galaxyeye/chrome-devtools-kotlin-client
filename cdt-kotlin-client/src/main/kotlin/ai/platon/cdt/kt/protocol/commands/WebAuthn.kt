@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.commands

import ai.platon.cdt.kt.protocol.events.webauthn.CredentialAdded
import ai.platon.cdt.kt.protocol.events.webauthn.CredentialAsserted
import ai.platon.cdt.kt.protocol.events.webauthn.CredentialDeleted
import ai.platon.cdt.kt.protocol.events.webauthn.CredentialUpdated
import ai.platon.cdt.kt.protocol.support.annotations.EventName
import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.support.annotations.ParamName
import ai.platon.cdt.kt.protocol.support.annotations.ReturnTypeParameter
import ai.platon.cdt.kt.protocol.support.annotations.Returns
import ai.platon.cdt.kt.protocol.support.types.EventHandler
import ai.platon.cdt.kt.protocol.support.types.EventListener
import ai.platon.cdt.kt.protocol.types.webauthn.Credential
import ai.platon.cdt.kt.protocol.types.webauthn.VirtualAuthenticatorOptions
import kotlin.Boolean
import kotlin.String
import kotlin.Unit
import kotlin.collections.List

/**
 * This domain allows configuring virtual authenticators to test the WebAuthn
 * API.
 */
@Experimental
interface WebAuthn {
  /**
   * Enable the WebAuthn domain and start intercepting credential storage and
   * retrieval with a virtual authenticator.
   * @param enableUI Whether to enable the WebAuthn user interface. Enabling the UI is
   * recommended for debugging and demo purposes, as it is closer to the real
   * experience. Disabling the UI is recommended for automated testing.
   * Supported at the embedder's discretion if UI is available.
   * Defaults to false.
   */
  suspend fun enable(@ParamName("enableUI") @Optional enableUI: Boolean? = null)

  suspend fun enable() {
    return enable(null)
  }

  /**
   * Disable the WebAuthn domain.
   */
  suspend fun disable()

  /**
   * Creates and adds a virtual authenticator.
   * @param options
   */
  @Returns("authenticatorId")
  suspend fun addVirtualAuthenticator(@ParamName("options") options: VirtualAuthenticatorOptions): String

  /**
   * Resets parameters isBogusSignature, isBadUV, isBadUP to false if they are not present.
   * @param authenticatorId
   * @param isBogusSignature If isBogusSignature is set, overrides the signature in the authenticator response to be zero.
   * Defaults to false.
   * @param isBadUV If isBadUV is set, overrides the UV bit in the flags in the authenticator response to
   * be zero. Defaults to false.
   * @param isBadUP If isBadUP is set, overrides the UP bit in the flags in the authenticator response to
   * be zero. Defaults to false.
   */
  suspend fun setResponseOverrideBits(
    @ParamName("authenticatorId") authenticatorId: String,
    @ParamName("isBogusSignature") @Optional isBogusSignature: Boolean? = null,
    @ParamName("isBadUV") @Optional isBadUV: Boolean? = null,
    @ParamName("isBadUP") @Optional isBadUP: Boolean? = null,
  )

  suspend fun setResponseOverrideBits(@ParamName("authenticatorId") authenticatorId: String) {
    return setResponseOverrideBits(authenticatorId, null, null, null)
  }

  /**
   * Removes the given authenticator.
   * @param authenticatorId
   */
  suspend fun removeVirtualAuthenticator(@ParamName("authenticatorId") authenticatorId: String)

  /**
   * Adds the credential to the specified authenticator.
   * @param authenticatorId
   * @param credential
   */
  suspend fun addCredential(@ParamName("authenticatorId") authenticatorId: String, @ParamName("credential") credential: Credential)

  /**
   * Returns a single credential stored in the given virtual authenticator that
   * matches the credential ID.
   * @param authenticatorId
   * @param credentialId
   */
  @Returns("credential")
  suspend fun getCredential(@ParamName("authenticatorId") authenticatorId: String, @ParamName("credentialId") credentialId: String): Credential

  /**
   * Returns all the credentials stored in the given virtual authenticator.
   * @param authenticatorId
   */
  @Returns("credentials")
  @ReturnTypeParameter(Credential::class)
  suspend fun getCredentials(@ParamName("authenticatorId") authenticatorId: String): List<Credential>

  /**
   * Removes a credential from the authenticator.
   * @param authenticatorId
   * @param credentialId
   */
  suspend fun removeCredential(@ParamName("authenticatorId") authenticatorId: String, @ParamName("credentialId") credentialId: String)

  /**
   * Clears all the credentials from the specified device.
   * @param authenticatorId
   */
  suspend fun clearCredentials(@ParamName("authenticatorId") authenticatorId: String)

  /**
   * Sets whether User Verification succeeds or fails for an authenticator.
   * The default is true.
   * @param authenticatorId
   * @param isUserVerified
   */
  suspend fun setUserVerified(@ParamName("authenticatorId") authenticatorId: String, @ParamName("isUserVerified") isUserVerified: Boolean)

  /**
   * Sets whether tests of user presence will succeed immediately (if true) or fail to resolve (if false) for an authenticator.
   * The default is true.
   * @param authenticatorId
   * @param enabled
   */
  suspend fun setAutomaticPresenceSimulation(@ParamName("authenticatorId") authenticatorId: String, @ParamName("enabled") enabled: Boolean)

  /**
   * Allows setting credential properties.
   * https://w3c.github.io/webauthn/#sctn-automation-set-credential-properties
   * @param authenticatorId
   * @param credentialId
   * @param backupEligibility
   * @param backupState
   */
  suspend fun setCredentialProperties(
    @ParamName("authenticatorId") authenticatorId: String,
    @ParamName("credentialId") credentialId: String,
    @ParamName("backupEligibility") @Optional backupEligibility: Boolean? = null,
    @ParamName("backupState") @Optional backupState: Boolean? = null,
  )

  suspend fun setCredentialProperties(@ParamName("authenticatorId") authenticatorId: String, @ParamName("credentialId") credentialId: String) {
    return setCredentialProperties(authenticatorId, credentialId, null, null)
  }

  @EventName("credentialAdded")
  fun onCredentialAdded(eventListener: EventHandler<CredentialAdded>): EventListener

  @EventName("credentialAdded")
  fun onCredentialAdded(eventListener: suspend (CredentialAdded) -> Unit): EventListener

  @EventName("credentialDeleted")
  fun onCredentialDeleted(eventListener: EventHandler<CredentialDeleted>): EventListener

  @EventName("credentialDeleted")
  fun onCredentialDeleted(eventListener: suspend (CredentialDeleted) -> Unit): EventListener

  @EventName("credentialUpdated")
  fun onCredentialUpdated(eventListener: EventHandler<CredentialUpdated>): EventListener

  @EventName("credentialUpdated")
  fun onCredentialUpdated(eventListener: suspend (CredentialUpdated) -> Unit): EventListener

  @EventName("credentialAsserted")
  fun onCredentialAsserted(eventListener: EventHandler<CredentialAsserted>): EventListener

  @EventName("credentialAsserted")
  fun onCredentialAsserted(eventListener: suspend (CredentialAsserted) -> Unit): EventListener
}
