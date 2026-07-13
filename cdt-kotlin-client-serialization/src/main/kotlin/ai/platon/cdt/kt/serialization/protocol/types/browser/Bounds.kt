@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.browser

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Int
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Browser window bounds information
 */
@Serializable
@Experimental
data class Bounds(
  @property:SerialName("left")
  @param:Optional
  val left: Int? = null,
  @property:SerialName("top")
  @param:Optional
  val top: Int? = null,
  @property:SerialName("width")
  @param:Optional
  val width: Int? = null,
  @property:SerialName("height")
  @param:Optional
  val height: Int? = null,
  @property:SerialName("windowState")
  @param:Optional
  val windowState: WindowState? = null,
)
