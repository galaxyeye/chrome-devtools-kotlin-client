@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.page

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * Image compression format.
 */
public enum class StartScreencastFormat {
  @JsonProperty("jpeg")
  JPEG,
  @JsonProperty("png")
  PNG,
  @JsonEnumDefaultValue
  UNKNOWN,
}
