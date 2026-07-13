@file:Suppress("unused")
package ai.platon.browser4.chrome.protocol.types.dom

import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Backend node with a friendly name.
 */
@Serializable
data class BackendNode(
  @property:SerialName("nodeType")
  val nodeType: Int,
  @property:SerialName("nodeName")
  val nodeName: String,
  @property:SerialName("backendNodeId")
  val backendNodeId: Int,
)
