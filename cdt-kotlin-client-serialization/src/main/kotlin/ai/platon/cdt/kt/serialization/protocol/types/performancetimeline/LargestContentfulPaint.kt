@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.performancetimeline

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * See https://github.com/WICG/LargestContentfulPaint and largest_contentful_paint.idl
 */
@Serializable
data class LargestContentfulPaint(
  @property:SerialName("renderTime")
  val renderTime: Double,
  @property:SerialName("loadTime")
  val loadTime: Double,
  @property:SerialName("size")
  val size: Double,
  @property:SerialName("elementId")
  @param:Optional
  val elementId: String? = null,
  @property:SerialName("url")
  @param:Optional
  val url: String? = null,
  @property:SerialName("nodeId")
  @param:Optional
  val nodeId: Int? = null,
)
