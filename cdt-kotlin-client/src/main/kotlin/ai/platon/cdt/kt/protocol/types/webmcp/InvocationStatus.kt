@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.webmcp

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * Represents the status of a tool invocation.
 */
public enum class InvocationStatus {
  @JsonProperty("Completed")
  COMPLETED,
  @JsonProperty("Canceled")
  CANCELED,
  @JsonProperty("Error")
  ERROR,
  @JsonEnumDefaultValue
  UNKNOWN,
}
