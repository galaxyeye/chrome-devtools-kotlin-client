@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Represents the failure reason when a getUserInfo() call fails.
 * Should be updated alongside FederatedAuthUserInfoRequestResult in
 * third_party/blink/public/mojom/devtools/inspector_issue.mojom.
 */
@Serializable
public enum class FederatedAuthUserInfoRequestIssueReason {
  @SerialName("NotSameOrigin")
  NOT_SAME_ORIGIN,
  @SerialName("NotIframe")
  NOT_IFRAME,
  @SerialName("NotPotentiallyTrustworthy")
  NOT_POTENTIALLY_TRUSTWORTHY,
  @SerialName("NoApiPermission")
  NO_API_PERMISSION,
  @SerialName("NotSignedInWithIdp")
  NOT_SIGNED_IN_WITH_IDP,
  @SerialName("NoAccountSharingPermission")
  NO_ACCOUNT_SHARING_PERMISSION,
  @SerialName("InvalidConfigOrWellKnown")
  INVALID_CONFIG_OR_WELL_KNOWN,
  @SerialName("InvalidAccountsResponse")
  INVALID_ACCOUNTS_RESPONSE,
  @SerialName("NoReturningUserFromFetchedAccounts")
  NO_RETURNING_USER_FROM_FETCHED_ACCOUNTS,
  UNKNOWN,
}
