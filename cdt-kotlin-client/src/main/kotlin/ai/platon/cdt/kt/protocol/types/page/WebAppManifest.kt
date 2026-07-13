@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.page

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.String
import kotlin.collections.List

@Experimental
data class WebAppManifest(
  @param:JsonProperty("backgroundColor")
  @param:Optional
  val backgroundColor: String? = null,
  @param:JsonProperty("description")
  @param:Optional
  val description: String? = null,
  @param:JsonProperty("dir")
  @param:Optional
  val dir: String? = null,
  @param:JsonProperty("display")
  @param:Optional
  val display: String? = null,
  @param:JsonProperty("displayOverrides")
  @param:Optional
  val displayOverrides: List<String>? = null,
  @param:JsonProperty("fileHandlers")
  @param:Optional
  val fileHandlers: List<FileHandler>? = null,
  @param:JsonProperty("icons")
  @param:Optional
  val icons: List<ImageResource>? = null,
  @param:JsonProperty("id")
  @param:Optional
  val id: String? = null,
  @param:JsonProperty("lang")
  @param:Optional
  val lang: String? = null,
  @param:JsonProperty("launchHandler")
  @param:Optional
  val launchHandler: LaunchHandler? = null,
  @param:JsonProperty("name")
  @param:Optional
  val name: String? = null,
  @param:JsonProperty("orientation")
  @param:Optional
  val orientation: String? = null,
  @param:JsonProperty("preferRelatedApplications")
  @param:Optional
  val preferRelatedApplications: Boolean? = null,
  @param:JsonProperty("protocolHandlers")
  @param:Optional
  val protocolHandlers: List<ProtocolHandler>? = null,
  @param:JsonProperty("relatedApplications")
  @param:Optional
  val relatedApplications: List<RelatedApplication>? = null,
  @param:JsonProperty("scope")
  @param:Optional
  val scope: String? = null,
  @param:JsonProperty("scopeExtensions")
  @param:Optional
  val scopeExtensions: List<ScopeExtension>? = null,
  @param:JsonProperty("screenshots")
  @param:Optional
  val screenshots: List<Screenshot>? = null,
  @param:JsonProperty("shareTarget")
  @param:Optional
  val shareTarget: ShareTarget? = null,
  @param:JsonProperty("shortName")
  @param:Optional
  val shortName: String? = null,
  @param:JsonProperty("shortcuts")
  @param:Optional
  val shortcuts: List<Shortcut>? = null,
  @param:JsonProperty("startUrl")
  @param:Optional
  val startUrl: String? = null,
  @param:JsonProperty("themeColor")
  @param:Optional
  val themeColor: String? = null,
)
