@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.extensions

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * Storage areas.
 */
public enum class StorageArea {
  @JsonProperty("session")
  SESSION,
  @JsonProperty("local")
  LOCAL,
  @JsonProperty("sync")
  SYNC,
  @JsonProperty("managed")
  MANAGED,
  @JsonEnumDefaultValue
  UNKNOWN,
}
