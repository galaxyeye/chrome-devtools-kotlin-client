package ai.platon.cdt.kt.protocol.types.webauthn

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean

data class VirtualAuthenticatorOptions(
  @field:JsonProperty("protocol")
  val protocol: AuthenticatorProtocol,
  @field:JsonProperty("ctap2Version")
  @param:Optional
  val ctap2Version: Ctap2Version? = null,
  @field:JsonProperty("transport")
  val transport: AuthenticatorTransport,
  @field:JsonProperty("hasResidentKey")
  @param:Optional
  val hasResidentKey: Boolean? = null,
  @field:JsonProperty("hasUserVerification")
  @param:Optional
  val hasUserVerification: Boolean? = null,
  @field:JsonProperty("hasLargeBlob")
  @param:Optional
  val hasLargeBlob: Boolean? = null,
  @field:JsonProperty("hasCredBlob")
  @param:Optional
  val hasCredBlob: Boolean? = null,
  @field:JsonProperty("automaticPresenceSimulation")
  @param:Optional
  val automaticPresenceSimulation: Boolean? = null,
  @field:JsonProperty("isUserVerified")
  @param:Optional
  val isUserVerified: Boolean? = null,
)
