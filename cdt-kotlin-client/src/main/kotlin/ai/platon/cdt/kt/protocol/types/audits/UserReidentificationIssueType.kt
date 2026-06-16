@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.audits

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

public enum class UserReidentificationIssueType {
  @JsonProperty("BlockedFrameNavigation")
  BLOCKED_FRAME_NAVIGATION,
  @JsonProperty("BlockedSubresource")
  BLOCKED_SUBRESOURCE,
  @JsonProperty("NoisedCanvasReadback")
  NOISED_CANVAS_READBACK,
  @JsonEnumDefaultValue
  UNKNOWN,
}
