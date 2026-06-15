@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.performancetimeline
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Double
import kotlin.Int
import kotlin.String

/**
 * See https://github.com/WICG/LargestContentfulPaint and largest_contentful_paint.idl
 */
@Serializable
data class LargestContentfulPaint(
  @SerialName("renderTime")
  val renderTime: Double,
  @SerialName("loadTime")
  val loadTime: Double,
  @SerialName("size")
  val size: Double,
  @SerialName("elementId")
  @param:Optional
  val elementId: String? = null,
  @SerialName("url")
  @param:Optional
  val url: String? = null,
  @SerialName("nodeId")
  @param:Optional
  val nodeId: Int? = null,
)
