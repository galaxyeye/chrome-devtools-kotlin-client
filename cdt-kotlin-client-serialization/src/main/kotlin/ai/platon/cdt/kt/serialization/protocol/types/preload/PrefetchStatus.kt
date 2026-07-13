@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.preload

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * TODO(https://crbug.com/1384419): revisit the list of PrefetchStatus and
 * filter out the ones that aren't necessary to the developers.
 */
@Serializable
public enum class PrefetchStatus {
  @SerialName("PrefetchAllowed")
  PREFETCH_ALLOWED,
  @SerialName("PrefetchFailedIneligibleRedirect")
  PREFETCH_FAILED_INELIGIBLE_REDIRECT,
  @SerialName("PrefetchFailedInvalidRedirect")
  PREFETCH_FAILED_INVALID_REDIRECT,
  @SerialName("PrefetchFailedMIMENotSupported")
  PREFETCH_FAILED_MIME_NOT_SUPPORTED,
  @SerialName("PrefetchFailedNetError")
  PREFETCH_FAILED_NET_ERROR,
  @SerialName("PrefetchFailedNon2XX")
  PREFETCH_FAILED_NON_2XX,
  @SerialName("PrefetchEvictedAfterBrowsingDataRemoved")
  PREFETCH_EVICTED_AFTER_BROWSING_DATA_REMOVED,
  @SerialName("PrefetchEvictedAfterCandidateRemoved")
  PREFETCH_EVICTED_AFTER_CANDIDATE_REMOVED,
  @SerialName("PrefetchEvictedForNewerPrefetch")
  PREFETCH_EVICTED_FOR_NEWER_PREFETCH,
  @SerialName("PrefetchHeldback")
  PREFETCH_HELDBACK,
  @SerialName("PrefetchIneligibleRetryAfter")
  PREFETCH_INELIGIBLE_RETRY_AFTER,
  @SerialName("PrefetchIsPrivacyDecoy")
  PREFETCH_IS_PRIVACY_DECOY,
  @SerialName("PrefetchIsStale")
  PREFETCH_IS_STALE,
  @SerialName("PrefetchNotEligibleBlockedByConnectionAllowlist")
  PREFETCH_NOT_ELIGIBLE_BLOCKED_BY_CONNECTION_ALLOWLIST,
  @SerialName("PrefetchNotEligibleBrowserContextOffTheRecord")
  PREFETCH_NOT_ELIGIBLE_BROWSER_CONTEXT_OFF_THE_RECORD,
  @SerialName("PrefetchNotEligibleDataSaverEnabled")
  PREFETCH_NOT_ELIGIBLE_DATA_SAVER_ENABLED,
  @SerialName("PrefetchNotEligibleExistingProxy")
  PREFETCH_NOT_ELIGIBLE_EXISTING_PROXY,
  @SerialName("PrefetchNotEligibleHostIsNonUnique")
  PREFETCH_NOT_ELIGIBLE_HOST_IS_NON_UNIQUE,
  @SerialName("PrefetchNotEligibleNonDefaultStoragePartition")
  PREFETCH_NOT_ELIGIBLE_NON_DEFAULT_STORAGE_PARTITION,
  @SerialName("PrefetchNotEligibleSameSiteCrossOriginPrefetchRequiredProxy")
  PREFETCH_NOT_ELIGIBLE_SAME_SITE_CROSS_ORIGIN_PREFETCH_REQUIRED_PROXY,
  @SerialName("PrefetchNotEligibleSchemeIsNotHttps")
  PREFETCH_NOT_ELIGIBLE_SCHEME_IS_NOT_HTTPS,
  @SerialName("PrefetchNotEligibleUserHasCookies")
  PREFETCH_NOT_ELIGIBLE_USER_HAS_COOKIES,
  @SerialName("PrefetchNotEligibleUserHasServiceWorker")
  PREFETCH_NOT_ELIGIBLE_USER_HAS_SERVICE_WORKER,
  @SerialName("PrefetchNotEligibleUserHasServiceWorkerNoFetchHandler")
  PREFETCH_NOT_ELIGIBLE_USER_HAS_SERVICE_WORKER_NO_FETCH_HANDLER,
  @SerialName("PrefetchNotEligibleRedirectFromServiceWorker")
  PREFETCH_NOT_ELIGIBLE_REDIRECT_FROM_SERVICE_WORKER,
  @SerialName("PrefetchNotEligibleRedirectToServiceWorker")
  PREFETCH_NOT_ELIGIBLE_REDIRECT_TO_SERVICE_WORKER,
  @SerialName("PrefetchNotEligibleBatterySaverEnabled")
  PREFETCH_NOT_ELIGIBLE_BATTERY_SAVER_ENABLED,
  @SerialName("PrefetchNotEligiblePreloadingDisabled")
  PREFETCH_NOT_ELIGIBLE_PRELOADING_DISABLED,
  @SerialName("PrefetchNotFinishedInTime")
  PREFETCH_NOT_FINISHED_IN_TIME,
  @SerialName("PrefetchNotStarted")
  PREFETCH_NOT_STARTED,
  @SerialName("PrefetchNotUsedCookiesChanged")
  PREFETCH_NOT_USED_COOKIES_CHANGED,
  @SerialName("PrefetchProxyNotAvailable")
  PREFETCH_PROXY_NOT_AVAILABLE,
  @SerialName("PrefetchResponseUsed")
  PREFETCH_RESPONSE_USED,
  @SerialName("PrefetchSuccessfulButNotUsed")
  PREFETCH_SUCCESSFUL_BUT_NOT_USED,
  @SerialName("PrefetchNotUsedProbeFailed")
  PREFETCH_NOT_USED_PROBE_FAILED,
  @SerialName("PrefetchCancelledOnUserNavigation")
  PREFETCH_CANCELLED_ON_USER_NAVIGATION,
  UNKNOWN,
}
