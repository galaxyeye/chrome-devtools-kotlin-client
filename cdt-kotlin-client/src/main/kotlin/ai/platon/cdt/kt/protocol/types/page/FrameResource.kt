package ai.platon.cdt.kt.protocol.types.page

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.network.ResourceType
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.Double
import kotlin.String

/**
 * Information about the Resource on the page.
 */
@Experimental
data class FrameResource(
  @field:JsonProperty("url")
  val url: String,
  @field:JsonProperty("type")
  val type: ResourceType,
  @field:JsonProperty("mimeType")
  val mimeType: String,
  @field:JsonProperty("lastModified")
  @param:Optional
  val lastModified: Double? = null,
  @field:JsonProperty("contentSize")
  @param:Optional
  val contentSize: Double? = null,
  @field:JsonProperty("failed")
  @param:Optional
  val failed: Boolean? = null,
  @field:JsonProperty("canceled")
  @param:Optional
  val canceled: Boolean? = null,
)
