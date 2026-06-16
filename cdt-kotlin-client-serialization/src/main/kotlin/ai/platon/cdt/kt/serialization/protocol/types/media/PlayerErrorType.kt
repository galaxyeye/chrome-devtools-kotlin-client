@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.media

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class PlayerErrorType {
  @SerialName("pipeline_error")
  PIPELINE_ERROR,
  @SerialName("media_error")
  MEDIA_ERROR,
  UNKNOWN,
}
