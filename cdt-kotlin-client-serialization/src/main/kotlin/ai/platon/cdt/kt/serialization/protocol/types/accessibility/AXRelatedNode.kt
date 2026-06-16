@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.accessibility

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AXRelatedNode(
  @property:SerialName("backendDOMNodeId")
  val backendDOMNodeId: Int,
  @property:SerialName("idref")
  @param:Optional
  val idref: String? = null,
  @property:SerialName("text")
  @param:Optional
  val text: String? = null,
)
