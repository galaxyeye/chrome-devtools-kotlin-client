package ai.platon.cdt.kt.protocol.types.page

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String
import kotlin.collections.List

/**
 * Information about the Frame on the page.
 */
data class Frame(
  @field:JsonProperty("id")
  val id: String,
  @field:JsonProperty("parentId")
  @param:Optional
  val parentId: String? = null,
  @field:JsonProperty("loaderId")
  val loaderId: String,
  @field:JsonProperty("name")
  @param:Optional
  val name: String? = null,
  @field:JsonProperty("url")
  val url: String,
  @field:JsonProperty("urlFragment")
  @param:Optional
  @param:Experimental
  val urlFragment: String? = null,
  @field:JsonProperty("domainAndRegistry")
  @param:Experimental
  val domainAndRegistry: String,
  @field:JsonProperty("securityOrigin")
  val securityOrigin: String,
  @field:JsonProperty("mimeType")
  val mimeType: String,
  @field:JsonProperty("unreachableUrl")
  @param:Optional
  @param:Experimental
  val unreachableUrl: String? = null,
  @field:JsonProperty("adFrameType")
  @param:Optional
  @param:Experimental
  val adFrameType: AdFrameType? = null,
  @field:JsonProperty("secureContextType")
  @param:Experimental
  val secureContextType: SecureContextType,
  @field:JsonProperty("crossOriginIsolatedContextType")
  @param:Experimental
  val crossOriginIsolatedContextType: CrossOriginIsolatedContextType,
  @field:JsonProperty("gatedAPIFeatures")
  @param:Experimental
  val gatedAPIFeatures: List<GatedAPIFeatures>,
)
