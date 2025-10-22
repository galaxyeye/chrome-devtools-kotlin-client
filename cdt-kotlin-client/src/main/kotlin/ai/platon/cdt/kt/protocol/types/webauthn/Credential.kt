package ai.platon.cdt.kt.protocol.types.webauthn

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.Int
import kotlin.String

data class Credential(
  @field:JsonProperty("credentialId")
  val credentialId: String,
  @field:JsonProperty("isResidentCredential")
  val isResidentCredential: Boolean,
  @field:JsonProperty("rpId")
  @param:Optional
  val rpId: String? = null,
  @field:JsonProperty("privateKey")
  val privateKey: String,
  @field:JsonProperty("userHandle")
  @param:Optional
  val userHandle: String? = null,
  @field:JsonProperty("signCount")
  val signCount: Int,
  @field:JsonProperty("largeBlob")
  @param:Optional
  val largeBlob: String? = null,
)
