@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.storage
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Enum of possible storage types.
 */
@Serializable
public enum class StorageType {
  @SerialName("appcache")
  APPCACHE,
  @SerialName("cookies")
  COOKIES,
  @SerialName("file_systems")
  FILE_SYSTEMS,
  @SerialName("indexeddb")
  INDEXEDDB,
  @SerialName("local_storage")
  LOCAL_STORAGE,
  @SerialName("shader_cache")
  SHADER_CACHE,
  @SerialName("websql")
  WEBSQL,
  @SerialName("service_workers")
  SERVICE_WORKERS,
  @SerialName("cache_storage")
  CACHE_STORAGE,
  @SerialName("all")
  ALL,
  @SerialName("other")
  OTHER,
}
