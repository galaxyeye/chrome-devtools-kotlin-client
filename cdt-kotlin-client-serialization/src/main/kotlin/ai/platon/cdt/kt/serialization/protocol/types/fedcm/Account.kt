@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.fedcm

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Corresponds to IdentityRequestAccount
 */
@Serializable
data class Account(
  @property:SerialName("accountId")
  val accountId: String,
  @property:SerialName("email")
  val email: String,
  @property:SerialName("name")
  val name: String,
  @property:SerialName("givenName")
  val givenName: String,
  @property:SerialName("pictureUrl")
  val pictureUrl: String,
  @property:SerialName("idpConfigUrl")
  val idpConfigUrl: String,
  @property:SerialName("idpLoginUrl")
  val idpLoginUrl: String,
  @property:SerialName("loginState")
  val loginState: LoginState,
  @property:SerialName("termsOfServiceUrl")
  @param:Optional
  val termsOfServiceUrl: String? = null,
  @property:SerialName("privacyPolicyUrl")
  @param:Optional
  val privacyPolicyUrl: String? = null,
)
