@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.commands

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.support.annotations.ParamName
import ai.platon.cdt.kt.serialization.protocol.support.annotations.ReturnTypeParameter
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Returns
import ai.platon.cdt.kt.serialization.protocol.types.indexeddb.DatabaseWithObjectStores
import ai.platon.cdt.kt.serialization.protocol.types.indexeddb.KeyRange
import ai.platon.cdt.kt.serialization.protocol.types.indexeddb.Metadata
import ai.platon.cdt.kt.serialization.protocol.types.indexeddb.RequestData
import ai.platon.cdt.kt.serialization.protocol.types.storage.StorageBucket
import kotlin.Int
import kotlin.String
import kotlin.collections.List

@Experimental
interface IndexedDB {
  /**
   * Clears all entries from an object store.
   * @param securityOrigin At least and at most one of securityOrigin, storageKey, or storageBucket must be specified.
   * Security origin.
   * @param storageKey Storage key.
   * @param storageBucket Storage bucket. If not specified, it uses the default bucket.
   * @param databaseName Database name.
   * @param objectStoreName Object store name.
   */
  suspend fun clearObjectStore(
    @ParamName("securityOrigin") @Optional securityOrigin: String? = null,
    @ParamName("storageKey") @Optional storageKey: String? = null,
    @ParamName("storageBucket") @Optional storageBucket: StorageBucket? = null,
    @ParamName("databaseName") databaseName: String,
    @ParamName("objectStoreName") objectStoreName: String,
  )

  suspend fun clearObjectStore(@ParamName("databaseName") databaseName: String, @ParamName("objectStoreName") objectStoreName: String) {
    return clearObjectStore(null, null, null, databaseName, objectStoreName)
  }

  /**
   * Deletes a database.
   * @param securityOrigin At least and at most one of securityOrigin, storageKey, or storageBucket must be specified.
   * Security origin.
   * @param storageKey Storage key.
   * @param storageBucket Storage bucket. If not specified, it uses the default bucket.
   * @param databaseName Database name.
   */
  suspend fun deleteDatabase(
    @ParamName("securityOrigin") @Optional securityOrigin: String? = null,
    @ParamName("storageKey") @Optional storageKey: String? = null,
    @ParamName("storageBucket") @Optional storageBucket: StorageBucket? = null,
    @ParamName("databaseName") databaseName: String,
  )

  suspend fun deleteDatabase(@ParamName("databaseName") databaseName: String) {
    return deleteDatabase(null, null, null, databaseName)
  }

  /**
   * Delete a range of entries from an object store
   * @param securityOrigin At least and at most one of securityOrigin, storageKey, or storageBucket must be specified.
   * Security origin.
   * @param storageKey Storage key.
   * @param storageBucket Storage bucket. If not specified, it uses the default bucket.
   * @param databaseName
   * @param objectStoreName
   * @param keyRange Range of entry keys to delete
   */
  suspend fun deleteObjectStoreEntries(
    @ParamName("securityOrigin") @Optional securityOrigin: String? = null,
    @ParamName("storageKey") @Optional storageKey: String? = null,
    @ParamName("storageBucket") @Optional storageBucket: StorageBucket? = null,
    @ParamName("databaseName") databaseName: String,
    @ParamName("objectStoreName") objectStoreName: String,
    @ParamName("keyRange") keyRange: KeyRange,
  )

  suspend fun deleteObjectStoreEntries(
    @ParamName("databaseName") databaseName: String,
    @ParamName("objectStoreName") objectStoreName: String,
    @ParamName("keyRange") keyRange: KeyRange,
  ) {
    return deleteObjectStoreEntries(null, null, null, databaseName, objectStoreName, keyRange)
  }

  /**
   * Disables events from backend.
   */
  suspend fun disable()

  /**
   * Enables events from backend.
   */
  suspend fun enable()

  /**
   * Requests data from object store or index.
   * @param securityOrigin At least and at most one of securityOrigin, storageKey, or storageBucket must be specified.
   * Security origin.
   * @param storageKey Storage key.
   * @param storageBucket Storage bucket. If not specified, it uses the default bucket.
   * @param databaseName Database name.
   * @param objectStoreName Object store name.
   * @param indexName Index name. If not specified, it performs an object store data request.
   * @param skipCount Number of records to skip.
   * @param pageSize Number of records to fetch.
   * @param keyRange Key range.
   */
  suspend fun requestData(
    @ParamName("securityOrigin") @Optional securityOrigin: String? = null,
    @ParamName("storageKey") @Optional storageKey: String? = null,
    @ParamName("storageBucket") @Optional storageBucket: StorageBucket? = null,
    @ParamName("databaseName") databaseName: String,
    @ParamName("objectStoreName") objectStoreName: String,
    @ParamName("indexName") @Optional indexName: String? = null,
    @ParamName("skipCount") skipCount: Int,
    @ParamName("pageSize") pageSize: Int,
    @ParamName("keyRange") @Optional keyRange: KeyRange? = null,
  ): RequestData

  suspend fun requestData(
    @ParamName("databaseName") databaseName: String,
    @ParamName("objectStoreName") objectStoreName: String,
    @ParamName("skipCount") skipCount: Int,
    @ParamName("pageSize") pageSize: Int,
  ): RequestData {
    return requestData(null, null, null, databaseName, objectStoreName, null, skipCount, pageSize, null)
  }

  /**
   * Gets metadata of an object store.
   * @param securityOrigin At least and at most one of securityOrigin, storageKey, or storageBucket must be specified.
   * Security origin.
   * @param storageKey Storage key.
   * @param storageBucket Storage bucket. If not specified, it uses the default bucket.
   * @param databaseName Database name.
   * @param objectStoreName Object store name.
   */
  suspend fun getMetadata(
    @ParamName("securityOrigin") @Optional securityOrigin: String? = null,
    @ParamName("storageKey") @Optional storageKey: String? = null,
    @ParamName("storageBucket") @Optional storageBucket: StorageBucket? = null,
    @ParamName("databaseName") databaseName: String,
    @ParamName("objectStoreName") objectStoreName: String,
  ): Metadata

  suspend fun getMetadata(@ParamName("databaseName") databaseName: String, @ParamName("objectStoreName") objectStoreName: String): Metadata {
    return getMetadata(null, null, null, databaseName, objectStoreName)
  }

  /**
   * Requests database with given name in given frame.
   * @param securityOrigin At least and at most one of securityOrigin, storageKey, or storageBucket must be specified.
   * Security origin.
   * @param storageKey Storage key.
   * @param storageBucket Storage bucket. If not specified, it uses the default bucket.
   * @param databaseName Database name.
   */
  @Returns("databaseWithObjectStores")
  suspend fun requestDatabase(
    @ParamName("securityOrigin") @Optional securityOrigin: String? = null,
    @ParamName("storageKey") @Optional storageKey: String? = null,
    @ParamName("storageBucket") @Optional storageBucket: StorageBucket? = null,
    @ParamName("databaseName") databaseName: String,
  ): DatabaseWithObjectStores

  @Returns("databaseWithObjectStores")
  suspend fun requestDatabase(@ParamName("databaseName") databaseName: String): DatabaseWithObjectStores {
    return requestDatabase(null, null, null, databaseName)
  }

  /**
   * Requests database names for given security origin.
   * @param securityOrigin At least and at most one of securityOrigin, storageKey, or storageBucket must be specified.
   * Security origin.
   * @param storageKey Storage key.
   * @param storageBucket Storage bucket. If not specified, it uses the default bucket.
   */
  @Returns("databaseNames")
  @ReturnTypeParameter(String::class)
  suspend fun requestDatabaseNames(
    @ParamName("securityOrigin") @Optional securityOrigin: String? = null,
    @ParamName("storageKey") @Optional storageKey: String? = null,
    @ParamName("storageBucket") @Optional storageBucket: StorageBucket? = null,
  ): List<String>

  @Returns("databaseNames")
  @ReturnTypeParameter(String::class)
  suspend fun requestDatabaseNames(): List<String> {
    return requestDatabaseNames(null, null, null)
  }
}
