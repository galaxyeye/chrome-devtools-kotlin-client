@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.webauthn
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Boolean
import kotlin.Int
import kotlin.String

@Serializable
data class Credential(
  @SerialName("credentialId")
  val credentialId: String,
  @SerialName("isResidentCredential")
  val isResidentCredential: Boolean,
  @SerialName("rpId")
  @param:Optional
  val rpId: String? = null,
  @SerialName("privateKey")
  val privateKey: String,
  @SerialName("userHandle")
  @param:Optional
  val userHandle: String? = null,
  @SerialName("signCount")
  val signCount: Int,
  @SerialName("largeBlob")
  @param:Optional
  val largeBlob: String? = null,
)
