@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.tracing

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Data format of a trace. Can be either the legacy JSON format or the
 * protocol buffer format. Note that the JSON format will be deprecated soon.
 */
@Serializable
public enum class StreamFormat {
  @SerialName("json")
  JSON,
  @SerialName("proto")
  PROTO,
  UNKNOWN,
}
