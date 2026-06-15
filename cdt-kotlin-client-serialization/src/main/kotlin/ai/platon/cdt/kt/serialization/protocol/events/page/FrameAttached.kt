@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.page
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.runtime.StackTrace
import kotlin.String

/**
 * Fired when frame has been attached to its parent.
 */
@Serializable
data class FrameAttached(
  @SerialName("frameId")
  val frameId: String,
  @SerialName("parentFrameId")
  val parentFrameId: String,
  @SerialName("stack")
  @param:Optional
  val stack: StackTrace? = null,
)
