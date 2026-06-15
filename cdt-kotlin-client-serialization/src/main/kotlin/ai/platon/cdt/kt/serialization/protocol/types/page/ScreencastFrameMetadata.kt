@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Double

/**
 * Screencast frame metadata.
 */
@Experimental
@Serializable
data class ScreencastFrameMetadata(
  @SerialName("offsetTop")
  val offsetTop: Double,
  @SerialName("pageScaleFactor")
  val pageScaleFactor: Double,
  @SerialName("deviceWidth")
  val deviceWidth: Double,
  @SerialName("deviceHeight")
  val deviceHeight: Double,
  @SerialName("scrollOffsetX")
  val scrollOffsetX: Double,
  @SerialName("scrollOffsetY")
  val scrollOffsetY: Double,
  @SerialName("timestamp")
  @param:Optional
  val timestamp: Double? = null,
)
