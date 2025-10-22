package ai.platon.cdt.kt.protocol.types.domstorage

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.String

/**
 * DOM Storage identifier.
 */
data class StorageId(
  @field:JsonProperty("securityOrigin")
  val securityOrigin: String,
  @field:JsonProperty("isLocalStorage")
  val isLocalStorage: Boolean,
)
