@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.page

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired when frame has stopped loading.
 */
@Serializable
@Experimental
data class FrameStoppedLoading(
  @property:SerialName("frameId")
  val frameId: String,
)
