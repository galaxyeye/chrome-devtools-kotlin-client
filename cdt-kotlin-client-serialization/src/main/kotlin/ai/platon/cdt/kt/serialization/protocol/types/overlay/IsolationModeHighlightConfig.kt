@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.overlay

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.dom.RGBA
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class IsolationModeHighlightConfig(
  @property:SerialName("resizerColor")
  @param:Optional
  val resizerColor: RGBA? = null,
  @property:SerialName("resizerHandleColor")
  @param:Optional
  val resizerHandleColor: RGBA? = null,
  @property:SerialName("maskColor")
  @param:Optional
  val maskColor: RGBA? = null,
)
