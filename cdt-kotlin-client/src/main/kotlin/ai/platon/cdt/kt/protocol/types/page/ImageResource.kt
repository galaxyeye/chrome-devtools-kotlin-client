@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.page

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * The image definition used in both icon and screenshot.
 */
@Experimental
data class ImageResource(
  @param:JsonProperty("url")
  val url: String,
  @param:JsonProperty("sizes")
  @param:Optional
  val sizes: String? = null,
  @param:JsonProperty("type")
  @param:Optional
  val type: String? = null,
)
