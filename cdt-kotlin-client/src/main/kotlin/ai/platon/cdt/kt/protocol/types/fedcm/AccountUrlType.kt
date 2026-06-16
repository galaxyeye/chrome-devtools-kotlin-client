@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.fedcm

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * The URLs that each account has
 */
public enum class AccountUrlType {
  @JsonProperty("TermsOfService")
  TERMS_OF_SERVICE,
  @JsonProperty("PrivacyPolicy")
  PRIVACY_POLICY,
  @JsonEnumDefaultValue
  UNKNOWN,
}
