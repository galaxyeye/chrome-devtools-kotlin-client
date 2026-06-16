@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Reason for a permissions policy feature to be disabled.
 */
@Serializable
public enum class PermissionsPolicyBlockReason {
  @SerialName("Header")
  HEADER,
  @SerialName("IframeAttribute")
  IFRAME_ATTRIBUTE,
  @SerialName("InFencedFrameTree")
  IN_FENCED_FRAME_TREE,
  @SerialName("InIsolatedApp")
  IN_ISOLATED_APP,
  UNKNOWN,
}
