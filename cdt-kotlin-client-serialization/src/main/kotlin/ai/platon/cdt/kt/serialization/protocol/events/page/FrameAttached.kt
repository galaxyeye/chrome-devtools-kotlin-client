@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.page

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.runtime.StackTrace
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired when frame has been attached to its parent.
 */
@Serializable
data class FrameAttached(
  @property:SerialName("frameId")
  val frameId: String,
  @property:SerialName("parentFrameId")
  val parentFrameId: String,
  @property:SerialName("stack")
  @param:Optional
  val stack: StackTrace? = null,
)
