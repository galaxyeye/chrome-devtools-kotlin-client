@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.accessibility
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Int
import kotlin.String

@Serializable
data class AXRelatedNode(
  @SerialName("backendDOMNodeId")
  val backendDOMNodeId: Int,
  @SerialName("idref")
  @param:Optional
  val idref: String? = null,
  @SerialName("text")
  @param:Optional
  val text: String? = null,
)
