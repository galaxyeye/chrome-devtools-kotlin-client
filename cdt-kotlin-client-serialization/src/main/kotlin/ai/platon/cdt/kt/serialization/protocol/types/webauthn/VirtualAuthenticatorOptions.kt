@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.webauthn
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Boolean

@Serializable
data class VirtualAuthenticatorOptions(
  @SerialName("protocol")
  val protocol: AuthenticatorProtocol,
  @SerialName("ctap2Version")
  @param:Optional
  val ctap2Version: Ctap2Version? = null,
  @SerialName("transport")
  val transport: AuthenticatorTransport,
  @SerialName("hasResidentKey")
  @param:Optional
  val hasResidentKey: Boolean? = null,
  @SerialName("hasUserVerification")
  @param:Optional
  val hasUserVerification: Boolean? = null,
  @SerialName("hasLargeBlob")
  @param:Optional
  val hasLargeBlob: Boolean? = null,
  @SerialName("hasCredBlob")
  @param:Optional
  val hasCredBlob: Boolean? = null,
  @SerialName("automaticPresenceSimulation")
  @param:Optional
  val automaticPresenceSimulation: Boolean? = null,
  @SerialName("isUserVerified")
  @param:Optional
  val isUserVerified: Boolean? = null,
)
