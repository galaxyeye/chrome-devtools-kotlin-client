@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Information about the Frame on the page.
 */
@Serializable
data class Frame(
  @property:SerialName("id")
  val id: String,
  @property:SerialName("parentId")
  @param:Optional
  val parentId: String? = null,
  @property:SerialName("loaderId")
  val loaderId: String,
  @property:SerialName("name")
  @param:Optional
  val name: String? = null,
  @property:SerialName("url")
  val url: String,
  @property:SerialName("urlFragment")
  @param:Optional
  @param:Experimental
  val urlFragment: String? = null,
  @property:SerialName("domainAndRegistry")
  @param:Experimental
  val domainAndRegistry: String,
  @property:SerialName("securityOrigin")
  val securityOrigin: String,
  @property:SerialName("mimeType")
  val mimeType: String,
  @property:SerialName("unreachableUrl")
  @param:Optional
  @param:Experimental
  val unreachableUrl: String? = null,
  @property:SerialName("adFrameType")
  @param:Optional
  @param:Experimental
  val adFrameType: AdFrameType? = null,
  @property:SerialName("secureContextType")
  @param:Experimental
  val secureContextType: SecureContextType,
  @property:SerialName("crossOriginIsolatedContextType")
  @param:Experimental
  val crossOriginIsolatedContextType: CrossOriginIsolatedContextType,
  @property:SerialName("gatedAPIFeatures")
  @param:Experimental
  val gatedAPIFeatures: List<GatedAPIFeatures>,
)
