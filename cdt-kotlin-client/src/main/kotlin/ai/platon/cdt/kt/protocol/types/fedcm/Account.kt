@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.fedcm

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Corresponds to IdentityRequestAccount
 */
data class Account(
  @param:JsonProperty("accountId")
  val accountId: String,
  @param:JsonProperty("email")
  val email: String,
  @param:JsonProperty("name")
  val name: String,
  @param:JsonProperty("givenName")
  val givenName: String,
  @param:JsonProperty("pictureUrl")
  val pictureUrl: String,
  @param:JsonProperty("idpConfigUrl")
  val idpConfigUrl: String,
  @param:JsonProperty("idpLoginUrl")
  val idpLoginUrl: String,
  @param:JsonProperty("loginState")
  val loginState: LoginState,
  @param:JsonProperty("termsOfServiceUrl")
  @param:Optional
  val termsOfServiceUrl: String? = null,
  @param:JsonProperty("privacyPolicyUrl")
  @param:Optional
  val privacyPolicyUrl: String? = null,
)
