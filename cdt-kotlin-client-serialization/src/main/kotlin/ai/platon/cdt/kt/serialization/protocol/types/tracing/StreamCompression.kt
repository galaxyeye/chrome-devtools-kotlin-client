@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.tracing

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Compression type to use for traces returned via streams.
 */
@Serializable
public enum class StreamCompression {
  @SerialName("none")
  NONE,
  @SerialName("gzip")
  GZIP,
  UNKNOWN,
}
