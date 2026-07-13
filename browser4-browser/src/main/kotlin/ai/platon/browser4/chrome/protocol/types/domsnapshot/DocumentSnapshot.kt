@file:Suppress("unused")
package ai.platon.browser4.chrome.protocol.types.domsnapshot

import ai.platon.browser4.chrome.protocol.support.annotations.Optional
import kotlin.Double
import kotlin.Int
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Document snapshot.
 */
@Serializable
data class DocumentSnapshot(
  @property:SerialName("documentURL")
  val documentURL: Int,
  @property:SerialName("title")
  val title: Int,
  @property:SerialName("baseURL")
  val baseURL: Int,
  @property:SerialName("contentLanguage")
  val contentLanguage: Int,
  @property:SerialName("encodingName")
  val encodingName: Int,
  @property:SerialName("publicId")
  val publicId: Int,
  @property:SerialName("systemId")
  val systemId: Int,
  @property:SerialName("frameId")
  val frameId: Int,
  @property:SerialName("nodes")
  val nodes: NodeTreeSnapshot,
  @property:SerialName("layout")
  val layout: LayoutTreeSnapshot,
  @property:SerialName("textBoxes")
  val textBoxes: TextBoxSnapshot,
  @property:SerialName("scrollOffsetX")
  @param:Optional
  val scrollOffsetX: Double? = null,
  @property:SerialName("scrollOffsetY")
  @param:Optional
  val scrollOffsetY: Double? = null,
  @property:SerialName("contentWidth")
  @param:Optional
  val contentWidth: Double? = null,
  @property:SerialName("contentHeight")
  @param:Optional
  val contentHeight: Double? = null,
)
