package ai.platon.cdt.kt.protocol.types.domsnapshot

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.Int

/**
 * Document snapshot.
 */
public data class DocumentSnapshot(
  @field:JsonProperty("documentURL")
  public val documentURL: Int,
  @field:JsonProperty("title")
  public val title: Int,
  @field:JsonProperty("baseURL")
  public val baseURL: Int,
  @field:JsonProperty("contentLanguage")
  public val contentLanguage: Int,
  @field:JsonProperty("encodingName")
  public val encodingName: Int,
  @field:JsonProperty("publicId")
  public val publicId: Int,
  @field:JsonProperty("systemId")
  public val systemId: Int,
  @field:JsonProperty("frameId")
  public val frameId: Int,
  @field:JsonProperty("nodes")
  public val nodes: NodeTreeSnapshot,
  @field:JsonProperty("layout")
  public val layout: LayoutTreeSnapshot,
  @field:JsonProperty("textBoxes")
  public val textBoxes: TextBoxSnapshot,
  @field:JsonProperty("scrollOffsetX")
  @param:Optional
  public val scrollOffsetX: Double? = null,
  @field:JsonProperty("scrollOffsetY")
  @param:Optional
  public val scrollOffsetY: Double? = null,
  @field:JsonProperty("contentWidth")
  @param:Optional
  public val contentWidth: Double? = null,
  @field:JsonProperty("contentHeight")
  @param:Optional
  public val contentHeight: Double? = null,
)
