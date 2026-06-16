@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.webauthn

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Credential(
  @property:SerialName("credentialId")
  val credentialId: String,
  @property:SerialName("isResidentCredential")
  val isResidentCredential: Boolean,
  @property:SerialName("rpId")
  @param:Optional
  val rpId: String? = null,
  @property:SerialName("privateKey")
  val privateKey: String,
  @property:SerialName("userHandle")
  @param:Optional
  val userHandle: String? = null,
  @property:SerialName("signCount")
  val signCount: Int,
  @property:SerialName("largeBlob")
  @param:Optional
  val largeBlob: String? = null,
)
