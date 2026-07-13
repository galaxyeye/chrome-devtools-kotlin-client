@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.page

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.types.page.ScreencastFrameMetadata
import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Compressed image data requested by the `startScreencast`.
 */
@Serializable
@Experimental
data class ScreencastFrame(
  @property:SerialName("data")
  val `data`: String,
  @property:SerialName("metadata")
  val metadata: ScreencastFrameMetadata,
  @property:SerialName("sessionId")
  val sessionId: Int,
)
