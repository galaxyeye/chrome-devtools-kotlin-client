@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.domstorage

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.String

/**
 * DOM Storage identifier.
 */
data class StorageId(
  @param:JsonProperty("securityOrigin")
  @param:Optional
  val securityOrigin: String? = null,
  @param:JsonProperty("storageKey")
  @param:Optional
  val storageKey: String? = null,
  @param:JsonProperty("isLocalStorage")
  val isLocalStorage: Boolean,
)
