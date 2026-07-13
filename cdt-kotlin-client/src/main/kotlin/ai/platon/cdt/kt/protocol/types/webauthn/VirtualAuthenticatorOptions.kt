@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.webauthn

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean

data class VirtualAuthenticatorOptions(
  @param:JsonProperty("protocol")
  val protocol: AuthenticatorProtocol,
  @param:JsonProperty("ctap2Version")
  @param:Optional
  val ctap2Version: Ctap2Version? = null,
  @param:JsonProperty("transport")
  val transport: AuthenticatorTransport,
  @param:JsonProperty("hasResidentKey")
  @param:Optional
  val hasResidentKey: Boolean? = null,
  @param:JsonProperty("hasUserVerification")
  @param:Optional
  val hasUserVerification: Boolean? = null,
  @param:JsonProperty("hasLargeBlob")
  @param:Optional
  val hasLargeBlob: Boolean? = null,
  @param:JsonProperty("hasCredBlob")
  @param:Optional
  val hasCredBlob: Boolean? = null,
  @param:JsonProperty("hasMinPinLength")
  @param:Optional
  val hasMinPinLength: Boolean? = null,
  @param:JsonProperty("hasPrf")
  @param:Optional
  val hasPrf: Boolean? = null,
  @param:JsonProperty("hasHmacSecret")
  @param:Optional
  val hasHmacSecret: Boolean? = null,
  @param:JsonProperty("hasHmacSecretMc")
  @param:Optional
  val hasHmacSecretMc: Boolean? = null,
  @param:JsonProperty("automaticPresenceSimulation")
  @param:Optional
  val automaticPresenceSimulation: Boolean? = null,
  @param:JsonProperty("isUserVerified")
  @param:Optional
  val isUserVerified: Boolean? = null,
  @param:JsonProperty("defaultBackupEligibility")
  @param:Optional
  val defaultBackupEligibility: Boolean? = null,
  @param:JsonProperty("defaultBackupState")
  @param:Optional
  val defaultBackupState: Boolean? = null,
)
