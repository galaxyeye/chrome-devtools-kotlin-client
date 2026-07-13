@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.tracing

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * Compression type to use for traces returned via streams.
 */
public enum class StreamCompression {
  @JsonProperty("none")
  NONE,
  @JsonProperty("gzip")
  GZIP,
  @JsonEnumDefaultValue
  UNKNOWN,
}
