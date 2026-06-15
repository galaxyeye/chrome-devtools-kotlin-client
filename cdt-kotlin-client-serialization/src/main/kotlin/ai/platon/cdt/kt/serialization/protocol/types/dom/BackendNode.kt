@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.dom
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Int
import kotlin.String

/**
 * Backend node with a friendly name.
 */
@Serializable
data class BackendNode(
  @SerialName("nodeType")
  val nodeType: Int,
  @SerialName("nodeName")
  val nodeName: String,
  @SerialName("backendNodeId")
  val backendNodeId: Int,
)
