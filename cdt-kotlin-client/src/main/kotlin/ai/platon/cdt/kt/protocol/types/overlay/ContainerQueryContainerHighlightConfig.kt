@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.overlay

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty

data class ContainerQueryContainerHighlightConfig(
  @param:JsonProperty("containerBorder")
  @param:Optional
  val containerBorder: LineStyle? = null,
  @param:JsonProperty("descendantBorder")
  @param:Optional
  val descendantBorder: LineStyle? = null,
)
