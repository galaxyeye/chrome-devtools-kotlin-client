@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.overlay

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.dom.RGBA
import com.fasterxml.jackson.`annotation`.JsonProperty

data class IsolationModeHighlightConfig(
  @param:JsonProperty("resizerColor")
  @param:Optional
  val resizerColor: RGBA? = null,
  @param:JsonProperty("resizerHandleColor")
  @param:Optional
  val resizerHandleColor: RGBA? = null,
  @param:JsonProperty("maskColor")
  @param:Optional
  val maskColor: RGBA? = null,
)
