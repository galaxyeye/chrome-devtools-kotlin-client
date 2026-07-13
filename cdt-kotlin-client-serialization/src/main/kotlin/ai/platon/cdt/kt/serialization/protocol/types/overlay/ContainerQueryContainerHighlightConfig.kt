@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.overlay

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ContainerQueryContainerHighlightConfig(
  @property:SerialName("containerBorder")
  @param:Optional
  val containerBorder: LineStyle? = null,
  @property:SerialName("descendantBorder")
  @param:Optional
  val descendantBorder: LineStyle? = null,
)
