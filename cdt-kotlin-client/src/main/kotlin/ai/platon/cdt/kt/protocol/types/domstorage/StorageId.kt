package ai.platon.cdt.kt.protocol.types.domstorage

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.String

/**
 * DOM Storage identifier.
 */
public data class StorageId(
  @field:JsonProperty("securityOrigin")
  public val securityOrigin: String,
  @field:JsonProperty("isLocalStorage")
  public val isLocalStorage: Boolean,
)
