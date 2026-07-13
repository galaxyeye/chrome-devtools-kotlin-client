@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.dom

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NodeForLocation(
  @property:SerialName("backendNodeId")
  val backendNodeId: Int,
  @property:SerialName("frameId")
  val frameId: String,
  @property:SerialName("nodeId")
  @param:Optional
  val nodeId: Int? = null,
)
