@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.commands

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.support.annotations.ParamName
import ai.platon.cdt.kt.protocol.support.annotations.ReturnTypeParameter
import ai.platon.cdt.kt.protocol.support.annotations.Returns
import ai.platon.cdt.kt.protocol.types.cachestorage.Cache
import ai.platon.cdt.kt.protocol.types.cachestorage.CachedResponse
import ai.platon.cdt.kt.protocol.types.cachestorage.Header
import ai.platon.cdt.kt.protocol.types.cachestorage.RequestEntries
import ai.platon.cdt.kt.protocol.types.storage.StorageBucket
import kotlin.Int
import kotlin.String
import kotlin.collections.List

@Experimental
interface CacheStorage {
  /**
   * Deletes a cache.
   * @param cacheId Id of cache for deletion.
   */
  suspend fun deleteCache(@ParamName("cacheId") cacheId: String)

  /**
   * Deletes a cache entry.
   * @param cacheId Id of cache where the entry will be deleted.
   * @param request URL spec of the request.
   */
  suspend fun deleteEntry(@ParamName("cacheId") cacheId: String, @ParamName("request") request: String)

  /**
   * Requests cache names.
   * @param securityOrigin At least and at most one of securityOrigin, storageKey, storageBucket must be specified.
   * Security origin.
   * @param storageKey Storage key.
   * @param storageBucket Storage bucket. If not specified, it uses the default bucket.
   */
  @Returns("caches")
  @ReturnTypeParameter(Cache::class)
  suspend fun requestCacheNames(
    @ParamName("securityOrigin") @Optional securityOrigin: String? = null,
    @ParamName("storageKey") @Optional storageKey: String? = null,
    @ParamName("storageBucket") @Optional storageBucket: StorageBucket? = null,
  ): List<Cache>

  @Returns("caches")
  @ReturnTypeParameter(Cache::class)
  suspend fun requestCacheNames(): List<Cache> {
    return requestCacheNames(null, null, null)
  }

  /**
   * Fetches cache entry.
   * @param cacheId Id of cache that contains the entry.
   * @param requestURL URL spec of the request.
   * @param requestHeaders headers of the request.
   */
  @Returns("response")
  suspend fun requestCachedResponse(
    @ParamName("cacheId") cacheId: String,
    @ParamName("requestURL") requestURL: String,
    @ParamName("requestHeaders") requestHeaders: List<Header>,
  ): CachedResponse

  /**
   * Requests data from cache.
   * @param cacheId ID of cache to get entries from.
   * @param skipCount Number of records to skip.
   * @param pageSize Number of records to fetch.
   * @param pathFilter If present, only return the entries containing this substring in the path
   */
  suspend fun requestEntries(
    @ParamName("cacheId") cacheId: String,
    @ParamName("skipCount") @Optional skipCount: Int? = null,
    @ParamName("pageSize") @Optional pageSize: Int? = null,
    @ParamName("pathFilter") @Optional pathFilter: String? = null,
  ): RequestEntries

  suspend fun requestEntries(@ParamName("cacheId") cacheId: String): RequestEntries {
    return requestEntries(cacheId, null, null, null)
  }
}
