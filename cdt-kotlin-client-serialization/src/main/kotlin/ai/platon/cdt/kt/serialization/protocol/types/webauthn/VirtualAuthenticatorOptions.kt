@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.webauthn

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Boolean
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VirtualAuthenticatorOptions(
  @property:SerialName("protocol")
  val protocol: AuthenticatorProtocol,
  @property:SerialName("ctap2Version")
  @param:Optional
  val ctap2Version: Ctap2Version? = null,
  @property:SerialName("transport")
  val transport: AuthenticatorTransport,
  @property:SerialName("hasResidentKey")
  @param:Optional
  val hasResidentKey: Boolean? = null,
  @property:SerialName("hasUserVerification")
  @param:Optional
  val hasUserVerification: Boolean? = null,
  @property:SerialName("hasLargeBlob")
  @param:Optional
  val hasLargeBlob: Boolean? = null,
  @property:SerialName("hasCredBlob")
  @param:Optional
  val hasCredBlob: Boolean? = null,
  @property:SerialName("hasMinPinLength")
  @param:Optional
  val hasMinPinLength: Boolean? = null,
  @property:SerialName("hasPrf")
  @param:Optional
  val hasPrf: Boolean? = null,
  @property:SerialName("hasHmacSecret")
  @param:Optional
  val hasHmacSecret: Boolean? = null,
  @property:SerialName("hasHmacSecretMc")
  @param:Optional
  val hasHmacSecretMc: Boolean? = null,
  @property:SerialName("automaticPresenceSimulation")
  @param:Optional
  val automaticPresenceSimulation: Boolean? = null,
  @property:SerialName("isUserVerified")
  @param:Optional
  val isUserVerified: Boolean? = null,
  @property:SerialName("defaultBackupEligibility")
  @param:Optional
  val defaultBackupEligibility: Boolean? = null,
  @property:SerialName("defaultBackupState")
  @param:Optional
  val defaultBackupState: Boolean? = null,
)
