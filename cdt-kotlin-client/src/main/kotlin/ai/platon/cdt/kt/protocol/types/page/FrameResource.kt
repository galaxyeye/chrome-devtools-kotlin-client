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
public data class FrameResource(
  @field:JsonProperty("url")
  public val url: String,
  @field:JsonProperty("type")
  public val type: ResourceType,
  @field:JsonProperty("mimeType")
  public val mimeType: String,
  @field:JsonProperty("lastModified")
  @param:Optional
  public val lastModified: Double? = null,
  @field:JsonProperty("contentSize")
  @param:Optional
  public val contentSize: Double? = null,
  @field:JsonProperty("failed")
  @param:Optional
  public val failed: Boolean? = null,
  @field:JsonProperty("canceled")
  @param:Optional
  public val canceled: Boolean? = null,
)
