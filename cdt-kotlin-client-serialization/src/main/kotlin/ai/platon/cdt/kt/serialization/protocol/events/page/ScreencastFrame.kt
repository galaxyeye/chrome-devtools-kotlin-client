@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.page
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.types.page.ScreencastFrameMetadata
import kotlin.Int
import kotlin.String

/**
 * Compressed image data requested by the `startScreencast`.
 */
@Experimental
@Serializable
data class ScreencastFrame(
  @SerialName("data")
  val `data`: String,
  @SerialName("metadata")
  val metadata: ScreencastFrameMetadata,
  @SerialName("sessionId")
  val sessionId: Int,
)
