@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Double
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Screencast frame metadata.
 */
@Serializable
@Experimental
data class ScreencastFrameMetadata(
  @property:SerialName("offsetTop")
  val offsetTop: Double,
  @property:SerialName("pageScaleFactor")
  val pageScaleFactor: Double,
  @property:SerialName("deviceWidth")
  val deviceWidth: Double,
  @property:SerialName("deviceHeight")
  val deviceHeight: Double,
  @property:SerialName("scrollOffsetX")
  val scrollOffsetX: Double,
  @property:SerialName("scrollOffsetY")
  val scrollOffsetY: Double,
  @property:SerialName("timestamp")
  @param:Optional
  val timestamp: Double? = null,
)
