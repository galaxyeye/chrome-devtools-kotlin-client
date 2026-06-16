@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.dom

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Int
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FrameOwner(
  @property:SerialName("backendNodeId")
  val backendNodeId: Int,
  @property:SerialName("nodeId")
  @param:Optional
  val nodeId: Int? = null,
)
