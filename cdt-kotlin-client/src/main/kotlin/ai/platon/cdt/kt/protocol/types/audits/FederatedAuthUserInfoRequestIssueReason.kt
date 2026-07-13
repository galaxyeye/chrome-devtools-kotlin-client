@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.audits

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * Represents the failure reason when a getUserInfo() call fails.
 * Should be updated alongside FederatedAuthUserInfoRequestResult in
 * third_party/blink/public/mojom/devtools/inspector_issue.mojom.
 */
public enum class FederatedAuthUserInfoRequestIssueReason {
  @JsonProperty("NotSameOrigin")
  NOT_SAME_ORIGIN,
  @JsonProperty("NotIframe")
  NOT_IFRAME,
  @JsonProperty("NotPotentiallyTrustworthy")
  NOT_POTENTIALLY_TRUSTWORTHY,
  @JsonProperty("NoApiPermission")
  NO_API_PERMISSION,
  @JsonProperty("NotSignedInWithIdp")
  NOT_SIGNED_IN_WITH_IDP,
  @JsonProperty("NoAccountSharingPermission")
  NO_ACCOUNT_SHARING_PERMISSION,
  @JsonProperty("InvalidConfigOrWellKnown")
  INVALID_CONFIG_OR_WELL_KNOWN,
  @JsonProperty("InvalidAccountsResponse")
  INVALID_ACCOUNTS_RESPONSE,
  @JsonProperty("NoReturningUserFromFetchedAccounts")
  NO_RETURNING_USER_FROM_FETCHED_ACCOUNTS,
  @JsonEnumDefaultValue
  UNKNOWN,
}
