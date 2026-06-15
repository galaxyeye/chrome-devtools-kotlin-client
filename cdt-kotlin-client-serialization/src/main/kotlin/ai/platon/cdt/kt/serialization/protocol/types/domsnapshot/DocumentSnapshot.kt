@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.domsnapshot
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Double
import kotlin.Int

/**
 * Document snapshot.
 */
@Serializable
data class DocumentSnapshot(
  @SerialName("documentURL")
  val documentURL: Int,
  @SerialName("title")
  val title: Int,
  @SerialName("baseURL")
  val baseURL: Int,
  @SerialName("contentLanguage")
  val contentLanguage: Int,
  @SerialName("encodingName")
  val encodingName: Int,
  @SerialName("publicId")
  val publicId: Int,
  @SerialName("systemId")
  val systemId: Int,
  @SerialName("frameId")
  val frameId: Int,
  @SerialName("nodes")
  val nodes: NodeTreeSnapshot,
  @SerialName("layout")
  val layout: LayoutTreeSnapshot,
  @SerialName("textBoxes")
  val textBoxes: TextBoxSnapshot,
  @SerialName("scrollOffsetX")
  @param:Optional
  val scrollOffsetX: Double? = null,
  @SerialName("scrollOffsetY")
  @param:Optional
  val scrollOffsetY: Double? = null,
  @SerialName("contentWidth")
  @param:Optional
  val contentWidth: Double? = null,
  @SerialName("contentHeight")
  @param:Optional
  val contentHeight: Double? = null,
)
