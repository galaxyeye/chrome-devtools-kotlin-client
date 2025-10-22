package ai.platon.cdt.kt.protocol.types.webauthn

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean

public data class VirtualAuthenticatorOptions(
  @field:JsonProperty("protocol")
  public val protocol: AuthenticatorProtocol,
  @field:JsonProperty("ctap2Version")
  @param:Optional
  public val ctap2Version: Ctap2Version? = null,
  @field:JsonProperty("transport")
  public val transport: AuthenticatorTransport,
  @field:JsonProperty("hasResidentKey")
  @param:Optional
  public val hasResidentKey: Boolean? = null,
  @field:JsonProperty("hasUserVerification")
  @param:Optional
  public val hasUserVerification: Boolean? = null,
  @field:JsonProperty("hasLargeBlob")
  @param:Optional
  public val hasLargeBlob: Boolean? = null,
  @field:JsonProperty("hasCredBlob")
  @param:Optional
  public val hasCredBlob: Boolean? = null,
  @field:JsonProperty("automaticPresenceSimulation")
  @param:Optional
  public val automaticPresenceSimulation: Boolean? = null,
  @field:JsonProperty("isUserVerified")
  @param:Optional
  public val isUserVerified: Boolean? = null,
)
