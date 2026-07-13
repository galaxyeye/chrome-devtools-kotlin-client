@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.overlay

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Int
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class InspectedElementAnchorConfig(
  @property:SerialName("nodeId")
  @param:Optional
  val nodeId: Int? = null,
  @property:SerialName("backendNodeId")
  @param:Optional
  val backendNodeId: Int? = null,
)
