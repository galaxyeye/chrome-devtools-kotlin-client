package ai.platon.cdt.kt.protocol.types.page

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String
import kotlin.collections.List

/**
 * Information about the Frame on the page.
 */
public data class Frame(
  @field:JsonProperty("id")
  public val id: String,
  @field:JsonProperty("parentId")
  @param:Optional
  public val parentId: String? = null,
  @field:JsonProperty("loaderId")
  public val loaderId: String,
  @field:JsonProperty("name")
  @param:Optional
  public val name: String? = null,
  @field:JsonProperty("url")
  public val url: String,
  @field:JsonProperty("urlFragment")
  @param:Optional
  @param:Experimental
  public val urlFragment: String? = null,
  @field:JsonProperty("domainAndRegistry")
  @param:Experimental
  public val domainAndRegistry: String,
  @field:JsonProperty("securityOrigin")
  public val securityOrigin: String,
  @field:JsonProperty("mimeType")
  public val mimeType: String,
  @field:JsonProperty("unreachableUrl")
  @param:Optional
  @param:Experimental
  public val unreachableUrl: String? = null,
  @field:JsonProperty("adFrameType")
  @param:Optional
  @param:Experimental
  public val adFrameType: AdFrameType? = null,
  @field:JsonProperty("secureContextType")
  @param:Experimental
  public val secureContextType: SecureContextType,
  @field:JsonProperty("crossOriginIsolatedContextType")
  @param:Experimental
  public val crossOriginIsolatedContextType: CrossOriginIsolatedContextType,
  @field:JsonProperty("gatedAPIFeatures")
  @param:Experimental
  public val gatedAPIFeatures: List<GatedAPIFeatures>,
)
