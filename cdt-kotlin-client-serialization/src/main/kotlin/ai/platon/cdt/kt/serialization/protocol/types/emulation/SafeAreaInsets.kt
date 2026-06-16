@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.emulation

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Int
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Experimental
data class SafeAreaInsets(
  @property:SerialName("top")
  @param:Optional
  val top: Int? = null,
  @property:SerialName("topMax")
  @param:Optional
  val topMax: Int? = null,
  @property:SerialName("left")
  @param:Optional
  val left: Int? = null,
  @property:SerialName("leftMax")
  @param:Optional
  val leftMax: Int? = null,
  @property:SerialName("bottom")
  @param:Optional
  val bottom: Int? = null,
  @property:SerialName("bottomMax")
  @param:Optional
  val bottomMax: Int? = null,
  @property:SerialName("right")
  @param:Optional
  val right: Int? = null,
  @property:SerialName("rightMax")
  @param:Optional
  val rightMax: Int? = null,
)
