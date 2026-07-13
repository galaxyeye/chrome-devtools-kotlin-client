@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.animation

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.dom.ScrollOrientation
import kotlin.Double
import kotlin.Int
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Timeline instance
 */
@Serializable
data class ViewOrScrollTimeline(
  @property:SerialName("sourceNodeId")
  @param:Optional
  val sourceNodeId: Int? = null,
  @property:SerialName("startOffset")
  @param:Optional
  val startOffset: Double? = null,
  @property:SerialName("endOffset")
  @param:Optional
  val endOffset: Double? = null,
  @property:SerialName("subjectNodeId")
  @param:Optional
  val subjectNodeId: Int? = null,
  @property:SerialName("axis")
  val axis: ScrollOrientation,
)
