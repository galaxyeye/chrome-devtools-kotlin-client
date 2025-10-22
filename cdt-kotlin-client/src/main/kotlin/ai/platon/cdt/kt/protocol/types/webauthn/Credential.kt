package ai.platon.cdt.kt.protocol.types.webauthn

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.Int
import kotlin.String

public data class Credential(
  @field:JsonProperty("credentialId")
  public val credentialId: String,
  @field:JsonProperty("isResidentCredential")
  public val isResidentCredential: Boolean,
  @field:JsonProperty("rpId")
  @param:Optional
  public val rpId: String? = null,
  @field:JsonProperty("privateKey")
  public val privateKey: String,
  @field:JsonProperty("userHandle")
  @param:Optional
  public val userHandle: String? = null,
  @field:JsonProperty("signCount")
  public val signCount: Int,
  @field:JsonProperty("largeBlob")
  @param:Optional
  public val largeBlob: String? = null,
)
