package ai.platon.cdt.kt.protocol.types.domsnapshot

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.Int

/**
 * Document snapshot.
 */
data class DocumentSnapshot(
  @field:JsonProperty("documentURL")
  val documentURL: Int,
  @field:JsonProperty("title")
  val title: Int,
  @field:JsonProperty("baseURL")
  val baseURL: Int,
  @field:JsonProperty("contentLanguage")
  val contentLanguage: Int,
  @field:JsonProperty("encodingName")
  val encodingName: Int,
  @field:JsonProperty("publicId")
  val publicId: Int,
  @field:JsonProperty("systemId")
  val systemId: Int,
  @field:JsonProperty("frameId")
  val frameId: Int,
  @field:JsonProperty("nodes")
  val nodes: NodeTreeSnapshot,
  @field:JsonProperty("layout")
  val layout: LayoutTreeSnapshot,
  @field:JsonProperty("textBoxes")
  val textBoxes: TextBoxSnapshot,
  @field:JsonProperty("scrollOffsetX")
  @param:Optional
  val scrollOffsetX: Double? = null,
  @field:JsonProperty("scrollOffsetY")
  @param:Optional
  val scrollOffsetY: Double? = null,
  @field:JsonProperty("contentWidth")
  @param:Optional
  val contentWidth: Double? = null,
  @field:JsonProperty("contentHeight")
  @param:Optional
  val contentHeight: Double? = null,
)
