@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.commands

import ai.platon.cdt.kt.serialization.protocol.events.storage.CacheStorageContentUpdated
import ai.platon.cdt.kt.serialization.protocol.events.storage.CacheStorageListUpdated
import ai.platon.cdt.kt.serialization.protocol.events.storage.IndexedDBContentUpdated
import ai.platon.cdt.kt.serialization.protocol.events.storage.IndexedDBListUpdated
import ai.platon.cdt.kt.serialization.protocol.events.storage.InterestGroupAccessed
import ai.platon.cdt.kt.serialization.protocol.events.storage.InterestGroupAuctionEventOccurred
import ai.platon.cdt.kt.serialization.protocol.events.storage.InterestGroupAuctionNetworkRequestCreated
import ai.platon.cdt.kt.serialization.protocol.events.storage.SharedStorageAccessed
import ai.platon.cdt.kt.serialization.protocol.events.storage.SharedStorageWorkletOperationExecutionFinished
import ai.platon.cdt.kt.serialization.protocol.events.storage.StorageBucketCreatedOrUpdated
import ai.platon.cdt.kt.serialization.protocol.events.storage.StorageBucketDeleted
import ai.platon.cdt.kt.serialization.protocol.support.annotations.EventName
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.support.annotations.ParamName
import ai.platon.cdt.kt.serialization.protocol.support.annotations.ReturnTypeParameter
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Returns
import ai.platon.cdt.kt.serialization.protocol.support.types.EventHandler
import ai.platon.cdt.kt.serialization.protocol.support.types.EventListener
import ai.platon.cdt.kt.serialization.protocol.types.network.Cookie
import ai.platon.cdt.kt.serialization.protocol.types.network.CookieParam
import ai.platon.cdt.kt.serialization.protocol.types.storage.RelatedWebsiteSet
import ai.platon.cdt.kt.serialization.protocol.types.storage.SharedStorageEntry
import ai.platon.cdt.kt.serialization.protocol.types.storage.SharedStorageMetadata
import ai.platon.cdt.kt.serialization.protocol.types.storage.StorageBucket
import ai.platon.cdt.kt.serialization.protocol.types.storage.TrustTokens
import ai.platon.cdt.kt.serialization.protocol.types.storage.UsageAndQuota
import kotlin.Boolean
import kotlin.Deprecated
import kotlin.Double
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import kotlinx.serialization.json.JsonObject

@Experimental
interface Storage {
  /**
   * Returns a storage key given a frame id.
   * Deprecated. Please use Storage.getStorageKey instead.
   * @param frameId
   */
  @Deprecated("Deprecated by protocol")
  @Returns("storageKey")
  suspend fun getStorageKeyForFrame(@ParamName("frameId") frameId: String): String

  /**
   * Returns storage key for the given frame. If no frame ID is provided,
   * the storage key of the target executing this command is returned.
   * @param frameId
   */
  @Experimental
  @Returns("storageKey")
  suspend fun getStorageKey(@ParamName("frameId") @Optional frameId: String? = null): String

  @Experimental
  @Returns("storageKey")
  suspend fun getStorageKey(): String {
    return getStorageKey(null)
  }

  /**
   * Clears storage for origin.
   * @param origin Security origin.
   * @param storageTypes Comma separated list of StorageType to clear.
   */
  suspend fun clearDataForOrigin(@ParamName("origin") origin: String, @ParamName("storageTypes") storageTypes: String)

  /**
   * Clears storage for storage key.
   * @param storageKey Storage key.
   * @param storageTypes Comma separated list of StorageType to clear.
   */
  suspend fun clearDataForStorageKey(@ParamName("storageKey") storageKey: String, @ParamName("storageTypes") storageTypes: String)

  /**
   * Returns all browser cookies.
   * @param browserContextId Browser context to use when called on the browser endpoint.
   */
  @Returns("cookies")
  @ReturnTypeParameter(Cookie::class)
  suspend fun getCookies(@ParamName("browserContextId") @Optional browserContextId: String? = null): List<Cookie>

  @Returns("cookies")
  @ReturnTypeParameter(Cookie::class)
  suspend fun getCookies(): List<Cookie> {
    return getCookies(null)
  }

  /**
   * Sets given cookies.
   * @param cookies Cookies to be set.
   * @param browserContextId Browser context to use when called on the browser endpoint.
   */
  suspend fun setCookies(@ParamName("cookies") cookies: List<CookieParam>, @ParamName("browserContextId") @Optional browserContextId: String? = null)

  suspend fun setCookies(@ParamName("cookies") cookies: List<CookieParam>) {
    return setCookies(cookies, null)
  }

  /**
   * Clears cookies.
   * @param browserContextId Browser context to use when called on the browser endpoint.
   */
  suspend fun clearCookies(@ParamName("browserContextId") @Optional browserContextId: String? = null)

  suspend fun clearCookies() {
    return clearCookies(null)
  }

  /**
   * Returns usage and quota in bytes.
   * @param origin Security origin.
   */
  suspend fun getUsageAndQuota(@ParamName("origin") origin: String): UsageAndQuota

  /**
   * Override quota for the specified origin
   * @param origin Security origin.
   * @param quotaSize The quota size (in bytes) to override the original quota with.
   * If this is called multiple times, the overridden quota will be equal to
   * the quotaSize provided in the final call. If this is called without
   * specifying a quotaSize, the quota will be reset to the default value for
   * the specified origin. If this is called multiple times with different
   * origins, the override will be maintained for each origin until it is
   * disabled (called without a quotaSize).
   */
  @Experimental
  suspend fun overrideQuotaForOrigin(@ParamName("origin") origin: String, @ParamName("quotaSize") @Optional quotaSize: Double? = null)

  @Experimental
  suspend fun overrideQuotaForOrigin(@ParamName("origin") origin: String) {
    return overrideQuotaForOrigin(origin, null)
  }

  /**
   * Registers origin to be notified when an update occurs to its cache storage list.
   * @param origin Security origin.
   */
  suspend fun trackCacheStorageForOrigin(@ParamName("origin") origin: String)

  /**
   * Registers storage key to be notified when an update occurs to its cache storage list.
   * @param storageKey Storage key.
   */
  suspend fun trackCacheStorageForStorageKey(@ParamName("storageKey") storageKey: String)

  /**
   * Registers origin to be notified when an update occurs to its IndexedDB.
   * @param origin Security origin.
   */
  suspend fun trackIndexedDBForOrigin(@ParamName("origin") origin: String)

  /**
   * Registers storage key to be notified when an update occurs to its IndexedDB.
   * @param storageKey Storage key.
   */
  suspend fun trackIndexedDBForStorageKey(@ParamName("storageKey") storageKey: String)

  /**
   * Unregisters origin from receiving notifications for cache storage.
   * @param origin Security origin.
   */
  suspend fun untrackCacheStorageForOrigin(@ParamName("origin") origin: String)

  /**
   * Unregisters storage key from receiving notifications for cache storage.
   * @param storageKey Storage key.
   */
  suspend fun untrackCacheStorageForStorageKey(@ParamName("storageKey") storageKey: String)

  /**
   * Unregisters origin from receiving notifications for IndexedDB.
   * @param origin Security origin.
   */
  suspend fun untrackIndexedDBForOrigin(@ParamName("origin") origin: String)

  /**
   * Unregisters storage key from receiving notifications for IndexedDB.
   * @param storageKey Storage key.
   */
  suspend fun untrackIndexedDBForStorageKey(@ParamName("storageKey") storageKey: String)

  /**
   * Returns the number of stored Trust Tokens per issuer for the
   * current browsing context.
   */
  @Experimental
  @Returns("tokens")
  @ReturnTypeParameter(TrustTokens::class)
  suspend fun getTrustTokens(): List<TrustTokens>

  /**
   * Removes all Trust Tokens issued by the provided issuerOrigin.
   * Leaves other stored data, including the issuer's Redemption Records, intact.
   * @param issuerOrigin
   */
  @Experimental
  @Returns("didDeleteTokens")
  suspend fun clearTrustTokens(@ParamName("issuerOrigin") issuerOrigin: String): Boolean

  /**
   * Gets details for a named interest group.
   * @param ownerOrigin
   * @param name
   */
  @Experimental
  @Returns("details")
  suspend fun getInterestGroupDetails(@ParamName("ownerOrigin") ownerOrigin: String, @ParamName("name") name: String): JsonObject?

  /**
   * Enables/Disables issuing of interestGroupAccessed events.
   * @param enable
   */
  @Experimental
  suspend fun setInterestGroupTracking(@ParamName("enable") enable: Boolean)

  /**
   * Enables/Disables issuing of interestGroupAuctionEventOccurred and
   * interestGroupAuctionNetworkRequestCreated.
   * @param enable
   */
  @Experimental
  suspend fun setInterestGroupAuctionTracking(@ParamName("enable") enable: Boolean)

  /**
   * Gets metadata for an origin's shared storage.
   * @param ownerOrigin
   */
  @Experimental
  @Returns("metadata")
  suspend fun getSharedStorageMetadata(@ParamName("ownerOrigin") ownerOrigin: String): SharedStorageMetadata

  /**
   * Gets the entries in an given origin's shared storage.
   * @param ownerOrigin
   */
  @Experimental
  @Returns("entries")
  @ReturnTypeParameter(SharedStorageEntry::class)
  suspend fun getSharedStorageEntries(@ParamName("ownerOrigin") ownerOrigin: String): List<SharedStorageEntry>

  /**
   * Sets entry with `key` and `value` for a given origin's shared storage.
   * @param ownerOrigin
   * @param key
   * @param value
   * @param ignoreIfPresent If `ignoreIfPresent` is included and true, then only sets the entry if
   * `key` doesn't already exist.
   */
  @Experimental
  suspend fun setSharedStorageEntry(
    @ParamName("ownerOrigin") ownerOrigin: String,
    @ParamName("key") key: String,
    @ParamName("value") `value`: String,
    @ParamName("ignoreIfPresent") @Optional ignoreIfPresent: Boolean? = null,
  )

  @Experimental
  suspend fun setSharedStorageEntry(
    @ParamName("ownerOrigin") ownerOrigin: String,
    @ParamName("key") key: String,
    @ParamName("value") `value`: String,
  ) {
    return setSharedStorageEntry(ownerOrigin, key, `value`, null)
  }

  /**
   * Deletes entry for `key` (if it exists) for a given origin's shared storage.
   * @param ownerOrigin
   * @param key
   */
  @Experimental
  suspend fun deleteSharedStorageEntry(@ParamName("ownerOrigin") ownerOrigin: String, @ParamName("key") key: String)

  /**
   * Clears all entries for a given origin's shared storage.
   * @param ownerOrigin
   */
  @Experimental
  suspend fun clearSharedStorageEntries(@ParamName("ownerOrigin") ownerOrigin: String)

  /**
   * Resets the budget for `ownerOrigin` by clearing all budget withdrawals.
   * @param ownerOrigin
   */
  @Experimental
  suspend fun resetSharedStorageBudget(@ParamName("ownerOrigin") ownerOrigin: String)

  /**
   * Enables/disables issuing of sharedStorageAccessed events.
   * @param enable
   */
  @Experimental
  suspend fun setSharedStorageTracking(@ParamName("enable") enable: Boolean)

  /**
   * Set tracking for a storage key's buckets.
   * @param storageKey
   * @param enable
   */
  @Experimental
  suspend fun setStorageBucketTracking(@ParamName("storageKey") storageKey: String, @ParamName("enable") enable: Boolean)

  /**
   * Deletes the Storage Bucket with the given storage key and bucket name.
   * @param bucket
   */
  @Experimental
  suspend fun deleteStorageBucket(@ParamName("bucket") bucket: StorageBucket)

  /**
   * Deletes state for sites identified as potential bounce trackers, immediately.
   */
  @Experimental
  @Returns("deletedSites")
  @ReturnTypeParameter(String::class)
  suspend fun runBounceTrackingMitigations(): List<String>

  /**
   * Returns the effective Related Website Sets in use by this profile for the browser
   * session. The effective Related Website Sets will not change during a browser session.
   */
  @Experimental
  @Returns("sets")
  @ReturnTypeParameter(RelatedWebsiteSet::class)
  suspend fun getRelatedWebsiteSets(): List<RelatedWebsiteSet>

  /**
   * @param owner
   * @param name
   * @param hashes
   */
  suspend fun setProtectedAudienceKAnonymity(
    @ParamName("owner") owner: String,
    @ParamName("name") name: String,
    @ParamName("hashes") hashes: List<String>,
  )

  @EventName("cacheStorageContentUpdated")
  fun onCacheStorageContentUpdated(eventListener: EventHandler<CacheStorageContentUpdated>): EventListener

  @EventName("cacheStorageContentUpdated")
  fun onCacheStorageContentUpdated(eventListener: suspend (CacheStorageContentUpdated) -> Unit): EventListener

  @EventName("cacheStorageListUpdated")
  fun onCacheStorageListUpdated(eventListener: EventHandler<CacheStorageListUpdated>): EventListener

  @EventName("cacheStorageListUpdated")
  fun onCacheStorageListUpdated(eventListener: suspend (CacheStorageListUpdated) -> Unit): EventListener

  @EventName("indexedDBContentUpdated")
  fun onIndexedDBContentUpdated(eventListener: EventHandler<IndexedDBContentUpdated>): EventListener

  @EventName("indexedDBContentUpdated")
  fun onIndexedDBContentUpdated(eventListener: suspend (IndexedDBContentUpdated) -> Unit): EventListener

  @EventName("indexedDBListUpdated")
  fun onIndexedDBListUpdated(eventListener: EventHandler<IndexedDBListUpdated>): EventListener

  @EventName("indexedDBListUpdated")
  fun onIndexedDBListUpdated(eventListener: suspend (IndexedDBListUpdated) -> Unit): EventListener

  @EventName("interestGroupAccessed")
  fun onInterestGroupAccessed(eventListener: EventHandler<InterestGroupAccessed>): EventListener

  @EventName("interestGroupAccessed")
  fun onInterestGroupAccessed(eventListener: suspend (InterestGroupAccessed) -> Unit): EventListener

  @EventName("interestGroupAuctionEventOccurred")
  fun onInterestGroupAuctionEventOccurred(eventListener: EventHandler<InterestGroupAuctionEventOccurred>): EventListener

  @EventName("interestGroupAuctionEventOccurred")
  fun onInterestGroupAuctionEventOccurred(eventListener: suspend (InterestGroupAuctionEventOccurred) -> Unit): EventListener

  @EventName("interestGroupAuctionNetworkRequestCreated")
  fun onInterestGroupAuctionNetworkRequestCreated(eventListener: EventHandler<InterestGroupAuctionNetworkRequestCreated>): EventListener

  @EventName("interestGroupAuctionNetworkRequestCreated")
  fun onInterestGroupAuctionNetworkRequestCreated(eventListener: suspend (InterestGroupAuctionNetworkRequestCreated) -> Unit): EventListener

  @EventName("sharedStorageAccessed")
  fun onSharedStorageAccessed(eventListener: EventHandler<SharedStorageAccessed>): EventListener

  @EventName("sharedStorageAccessed")
  fun onSharedStorageAccessed(eventListener: suspend (SharedStorageAccessed) -> Unit): EventListener

  @EventName("sharedStorageWorkletOperationExecutionFinished")
  fun onSharedStorageWorkletOperationExecutionFinished(eventListener: EventHandler<SharedStorageWorkletOperationExecutionFinished>): EventListener

  @EventName("sharedStorageWorkletOperationExecutionFinished")
  fun onSharedStorageWorkletOperationExecutionFinished(eventListener: suspend (SharedStorageWorkletOperationExecutionFinished) -> Unit): EventListener

  @EventName("storageBucketCreatedOrUpdated")
  fun onStorageBucketCreatedOrUpdated(eventListener: EventHandler<StorageBucketCreatedOrUpdated>): EventListener

  @EventName("storageBucketCreatedOrUpdated")
  fun onStorageBucketCreatedOrUpdated(eventListener: suspend (StorageBucketCreatedOrUpdated) -> Unit): EventListener

  @EventName("storageBucketDeleted")
  fun onStorageBucketDeleted(eventListener: EventHandler<StorageBucketDeleted>): EventListener

  @EventName("storageBucketDeleted")
  fun onStorageBucketDeleted(eventListener: suspend (StorageBucketDeleted) -> Unit): EventListener
}
