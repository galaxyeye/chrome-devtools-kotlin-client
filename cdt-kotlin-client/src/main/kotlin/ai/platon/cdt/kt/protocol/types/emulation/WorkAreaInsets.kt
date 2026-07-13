@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.emulation

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int

@Experimental
data class WorkAreaInsets(
  @param:JsonProperty("top")
  @param:Optional
  val top: Int? = null,
  @param:JsonProperty("left")
  @param:Optional
  val left: Int? = null,
  @param:JsonProperty("bottom")
  @param:Optional
  val bottom: Int? = null,
  @param:JsonProperty("right")
  @param:Optional
  val right: Int? = null,
)
