@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.domdebugger

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * DOM breakpoint type.
 */
@Serializable
public enum class DOMBreakpointType {
  @SerialName("subtree-modified")
  SUBTREE_MODIFIED,
  @SerialName("attribute-modified")
  ATTRIBUTE_MODIFIED,
  @SerialName("node-removed")
  NODE_REMOVED,
  UNKNOWN,
}
