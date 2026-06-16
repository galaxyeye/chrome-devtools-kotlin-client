@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.animation

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.dom.ScrollOrientation
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.Int

/**
 * Timeline instance
 */
data class ViewOrScrollTimeline(
  @param:JsonProperty("sourceNodeId")
  @param:Optional
  val sourceNodeId: Int? = null,
  @param:JsonProperty("startOffset")
  @param:Optional
  val startOffset: Double? = null,
  @param:JsonProperty("endOffset")
  @param:Optional
  val endOffset: Double? = null,
  @param:JsonProperty("subjectNodeId")
  @param:Optional
  val subjectNodeId: Int? = null,
  @param:JsonProperty("axis")
  val axis: ScrollOrientation,
)
