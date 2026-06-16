@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class UserReidentificationIssueType {
  @SerialName("BlockedFrameNavigation")
  BLOCKED_FRAME_NAVIGATION,
  @SerialName("BlockedSubresource")
  BLOCKED_SUBRESOURCE,
  @SerialName("NoisedCanvasReadback")
  NOISED_CANVAS_READBACK,
  UNKNOWN,
}
