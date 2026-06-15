@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.dom
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Int
import kotlin.String

@Serializable
data class NodeForLocation(
  @SerialName("backendNodeId")
  val backendNodeId: Int,
  @SerialName("frameId")
  val frameId: String,
  @SerialName("nodeId")
  @param:Optional
  val nodeId: Int? = null,
)
