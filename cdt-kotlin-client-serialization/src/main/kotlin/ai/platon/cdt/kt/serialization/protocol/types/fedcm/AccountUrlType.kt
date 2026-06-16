@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.fedcm

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The URLs that each account has
 */
@Serializable
public enum class AccountUrlType {
  @SerialName("TermsOfService")
  TERMS_OF_SERVICE,
  @SerialName("PrivacyPolicy")
  PRIVACY_POLICY,
  UNKNOWN,
}
