@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.dom
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Int

@Serializable
data class FrameOwner(
  @SerialName("backendNodeId")
  val backendNodeId: Int,
  @SerialName("nodeId")
  @param:Optional
  val nodeId: Int? = null,
)
