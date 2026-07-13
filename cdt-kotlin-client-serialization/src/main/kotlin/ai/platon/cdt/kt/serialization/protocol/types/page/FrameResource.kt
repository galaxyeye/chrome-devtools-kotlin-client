@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.network.ResourceType
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Information about the Resource on the page.
 */
@Serializable
@Experimental
data class FrameResource(
  @property:SerialName("url")
  val url: String,
  @property:SerialName("type")
  val type: ResourceType,
  @property:SerialName("mimeType")
  val mimeType: String,
  @property:SerialName("lastModified")
  @param:Optional
  val lastModified: Double? = null,
  @property:SerialName("contentSize")
  @param:Optional
  val contentSize: Double? = null,
  @property:SerialName("failed")
  @param:Optional
  val failed: Boolean? = null,
  @property:SerialName("canceled")
  @param:Optional
  val canceled: Boolean? = null,
)
