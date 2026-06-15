@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.network.ResourceType
import kotlin.Boolean
import kotlin.Double
import kotlin.String

/**
 * Information about the Resource on the page.
 */
@Experimental
@Serializable
data class FrameResource(
  @SerialName("url")
  val url: String,
  @SerialName("type")
  val type: ResourceType,
  @SerialName("mimeType")
  val mimeType: String,
  @SerialName("lastModified")
  @param:Optional
  val lastModified: Double? = null,
  @SerialName("contentSize")
  @param:Optional
  val contentSize: Double? = null,
  @SerialName("failed")
  @param:Optional
  val failed: Boolean? = null,
  @SerialName("canceled")
  @param:Optional
  val canceled: Boolean? = null,
)
