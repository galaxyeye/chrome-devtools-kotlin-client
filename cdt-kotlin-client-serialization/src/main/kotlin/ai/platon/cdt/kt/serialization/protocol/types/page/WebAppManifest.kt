@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Boolean
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Experimental
data class WebAppManifest(
  @property:SerialName("backgroundColor")
  @param:Optional
  val backgroundColor: String? = null,
  @property:SerialName("description")
  @param:Optional
  val description: String? = null,
  @property:SerialName("dir")
  @param:Optional
  val dir: String? = null,
  @property:SerialName("display")
  @param:Optional
  val display: String? = null,
  @property:SerialName("displayOverrides")
  @param:Optional
  val displayOverrides: List<String>? = null,
  @property:SerialName("fileHandlers")
  @param:Optional
  val fileHandlers: List<FileHandler>? = null,
  @property:SerialName("icons")
  @param:Optional
  val icons: List<ImageResource>? = null,
  @property:SerialName("id")
  @param:Optional
  val id: String? = null,
  @property:SerialName("lang")
  @param:Optional
  val lang: String? = null,
  @property:SerialName("launchHandler")
  @param:Optional
  val launchHandler: LaunchHandler? = null,
  @property:SerialName("name")
  @param:Optional
  val name: String? = null,
  @property:SerialName("orientation")
  @param:Optional
  val orientation: String? = null,
  @property:SerialName("preferRelatedApplications")
  @param:Optional
  val preferRelatedApplications: Boolean? = null,
  @property:SerialName("protocolHandlers")
  @param:Optional
  val protocolHandlers: List<ProtocolHandler>? = null,
  @property:SerialName("relatedApplications")
  @param:Optional
  val relatedApplications: List<RelatedApplication>? = null,
  @property:SerialName("scope")
  @param:Optional
  val scope: String? = null,
  @property:SerialName("scopeExtensions")
  @param:Optional
  val scopeExtensions: List<ScopeExtension>? = null,
  @property:SerialName("screenshots")
  @param:Optional
  val screenshots: List<Screenshot>? = null,
  @property:SerialName("shareTarget")
  @param:Optional
  val shareTarget: ShareTarget? = null,
  @property:SerialName("shortName")
  @param:Optional
  val shortName: String? = null,
  @property:SerialName("shortcuts")
  @param:Optional
  val shortcuts: List<Shortcut>? = null,
  @property:SerialName("startUrl")
  @param:Optional
  val startUrl: String? = null,
  @property:SerialName("themeColor")
  @param:Optional
  val themeColor: String? = null,
)
