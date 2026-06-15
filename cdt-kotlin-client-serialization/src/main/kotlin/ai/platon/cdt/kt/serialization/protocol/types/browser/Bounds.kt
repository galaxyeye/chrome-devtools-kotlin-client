@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.browser
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Int

/**
 * Browser window bounds information
 */
@Experimental
@Serializable
data class Bounds(
  @SerialName("left")
  @param:Optional
  val left: Int? = null,
  @SerialName("top")
  @param:Optional
  val top: Int? = null,
  @SerialName("width")
  @param:Optional
  val width: Int? = null,
  @SerialName("height")
  @param:Optional
  val height: Int? = null,
  @SerialName("windowState")
  @param:Optional
  val windowState: WindowState? = null,
)
