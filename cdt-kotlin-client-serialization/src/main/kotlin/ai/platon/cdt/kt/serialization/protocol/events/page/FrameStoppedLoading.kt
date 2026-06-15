@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.page
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.String

/**
 * Fired when frame has stopped loading.
 */
@Experimental
@Serializable
data class FrameStoppedLoading(
  @SerialName("frameId")
  val frameId: String,
)
