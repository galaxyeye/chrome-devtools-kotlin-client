@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlin.collections.List

/**
 * Information about the Frame on the page.
 */
@Serializable
data class Frame(
  @SerialName("id")
  val id: String,
  @SerialName("parentId")
  @param:Optional
  val parentId: String? = null,
  @SerialName("loaderId")
  val loaderId: String,
  @SerialName("name")
  @param:Optional
  val name: String? = null,
  @SerialName("url")
  val url: String,
  @SerialName("urlFragment")
  @param:Optional
  @param:Experimental
  val urlFragment: String? = null,
  @SerialName("domainAndRegistry")
  @param:Experimental
  val domainAndRegistry: String,
  @SerialName("securityOrigin")
  val securityOrigin: String,
  @SerialName("mimeType")
  val mimeType: String,
  @SerialName("unreachableUrl")
  @param:Optional
  @param:Experimental
  val unreachableUrl: String? = null,
  @SerialName("adFrameType")
  @param:Optional
  @param:Experimental
  val adFrameType: AdFrameType? = null,
  @SerialName("secureContextType")
  @param:Experimental
  val secureContextType: SecureContextType,
  @SerialName("crossOriginIsolatedContextType")
  @param:Experimental
  val crossOriginIsolatedContextType: CrossOriginIsolatedContextType,
  @SerialName("gatedAPIFeatures")
  @param:Experimental
  val gatedAPIFeatures: List<GatedAPIFeatures>,
)
