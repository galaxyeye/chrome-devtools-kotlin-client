@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.commands

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.support.annotations.ParamName
import ai.platon.cdt.kt.serialization.protocol.support.annotations.ReturnTypeParameter
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Returns
import ai.platon.cdt.kt.serialization.protocol.types.extensions.ExtensionInfo
import ai.platon.cdt.kt.serialization.protocol.types.extensions.StorageArea
import kotlin.Boolean
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.json.JsonObject

/**
 * Defines commands and events for browser extensions.
 */
@Experimental
interface Extensions {
  /**
   * Runs an extension default action.
   * @param id Extension id.
   * @param targetId A tab target ID to trigger the default extension action on.
   */
  suspend fun triggerAction(@ParamName("id") id: String, @ParamName("targetId") targetId: String)

  /**
   * Installs an unpacked extension from the filesystem similar to
   * --load-extension CLI flags. Returns extension ID once the extension
   * has been installed.
   * @param path Absolute file path.
   * @param enableInIncognito Enable the extension in incognito
   */
  @Returns("id")
  suspend fun loadUnpacked(@ParamName("path") path: String, @ParamName("enableInIncognito") @Optional enableInIncognito: Boolean? = null): String

  @Returns("id")
  suspend fun loadUnpacked(@ParamName("path") path: String): String {
    return loadUnpacked(path, null)
  }

  /**
   * Gets a list of all unpacked extensions.
   */
  @Returns("extensions")
  @ReturnTypeParameter(ExtensionInfo::class)
  suspend fun getExtensions(): List<ExtensionInfo>

  /**
   * Uninstalls an unpacked extension (others not supported) from the profile.
   * @param id Extension id.
   */
  suspend fun uninstall(@ParamName("id") id: String)

  /**
   * Gets data from extension storage in the given `storageArea`. If `keys` is
   * specified, these are used to filter the result.
   * @param id ID of extension.
   * @param storageArea StorageArea to retrieve data from.
   * @param keys Keys to retrieve.
   */
  @Returns("data")
  suspend fun getStorageItems(
    @ParamName("id") id: String,
    @ParamName("storageArea") storageArea: StorageArea,
    @ParamName("keys") @Optional keys: List<String>? = null,
  ): JsonObject?

  @Returns("data")
  suspend fun getStorageItems(@ParamName("id") id: String, @ParamName("storageArea") storageArea: StorageArea): JsonObject? {
    return getStorageItems(id, storageArea, null)
  }

  /**
   * Removes `keys` from extension storage in the given `storageArea`.
   * @param id ID of extension.
   * @param storageArea StorageArea to remove data from.
   * @param keys Keys to remove.
   */
  suspend fun removeStorageItems(
    @ParamName("id") id: String,
    @ParamName("storageArea") storageArea: StorageArea,
    @ParamName("keys") keys: List<String>,
  )

  /**
   * Clears extension storage in the given `storageArea`.
   * @param id ID of extension.
   * @param storageArea StorageArea to remove data from.
   */
  suspend fun clearStorageItems(@ParamName("id") id: String, @ParamName("storageArea") storageArea: StorageArea)

  /**
   * Sets `values` in extension storage in the given `storageArea`. The provided `values`
   * will be merged with existing values in the storage area.
   * @param id ID of extension.
   * @param storageArea StorageArea to set data in.
   * @param values Values to set.
   */
  suspend fun setStorageItems(
    @ParamName("id") id: String,
    @ParamName("storageArea") storageArea: StorageArea,
    @ParamName("values") values: JsonObject?,
  )
}
