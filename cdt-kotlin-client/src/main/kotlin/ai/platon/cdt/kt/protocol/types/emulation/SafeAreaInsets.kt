@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.emulation

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int

@Experimental
data class SafeAreaInsets(
  @param:JsonProperty("top")
  @param:Optional
  val top: Int? = null,
  @param:JsonProperty("topMax")
  @param:Optional
  val topMax: Int? = null,
  @param:JsonProperty("left")
  @param:Optional
  val left: Int? = null,
  @param:JsonProperty("leftMax")
  @param:Optional
  val leftMax: Int? = null,
  @param:JsonProperty("bottom")
  @param:Optional
  val bottom: Int? = null,
  @param:JsonProperty("bottomMax")
  @param:Optional
  val bottomMax: Int? = null,
  @param:JsonProperty("right")
  @param:Optional
  val right: Int? = null,
  @param:JsonProperty("rightMax")
  @param:Optional
  val rightMax: Int? = null,
)
