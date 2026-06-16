@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * The image definition used in both icon and screenshot.
 */
@Serializable
@Experimental
data class ImageResource(
  @property:SerialName("url")
  val url: String,
  @property:SerialName("sizes")
  @param:Optional
  val sizes: String? = null,
  @property:SerialName("type")
  @param:Optional
  val type: String? = null,
)
