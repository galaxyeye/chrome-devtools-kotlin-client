@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * List of content encodings supported by the backend.
 */
@Serializable
public enum class ContentEncoding {
  @SerialName("deflate")
  DEFLATE,
  @SerialName("gzip")
  GZIP,
  @SerialName("br")
  BR,
  @SerialName("zstd")
  ZSTD,
  UNKNOWN,
}
