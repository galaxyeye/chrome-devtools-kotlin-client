@file:Suppress("unused")
package ai.platon.browser4.chrome.protocol.types.network

import ai.platon.browser4.chrome.protocol.support.annotations.Experimental
import ai.platon.browser4.chrome.protocol.support.annotations.Optional
import ai.platon.browser4.chrome.protocol.types.security.MixedContentType
import kotlin.Boolean
import kotlin.Deprecated
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

/**
 * HTTP request data.
 */
@Serializable
data class Request(
  @property:SerialName("url")
  val url: String,
  @property:SerialName("urlFragment")
  @param:Optional
  val urlFragment: String? = null,
  @property:SerialName("method")
  val method: String,
  @property:SerialName("headers")
  val headers: JsonObject?,
  @property:SerialName("postData")
  @param:Optional
  @Deprecated("Deprecated by protocol")
  val postData: String? = null,
  @property:SerialName("hasPostData")
  @param:Optional
  val hasPostData: Boolean? = null,
  @property:SerialName("postDataEntries")
  @param:Optional
  @param:Experimental
  val postDataEntries: List<PostDataEntry>? = null,
  @property:SerialName("mixedContentType")
  @param:Optional
  val mixedContentType: MixedContentType? = null,
  @property:SerialName("initialPriority")
  val initialPriority: ResourcePriority,
  @property:SerialName("referrerPolicy")
  val referrerPolicy: RequestReferrerPolicy,
  @property:SerialName("isLinkPreload")
  @param:Optional
  val isLinkPreload: Boolean? = null,
  @property:SerialName("trustTokenParams")
  @param:Optional
  @param:Experimental
  val trustTokenParams: TrustTokenParams? = null,
  @property:SerialName("isSameSite")
  @param:Optional
  @param:Experimental
  val isSameSite: Boolean? = null,
  @property:SerialName("isAdRelated")
  @param:Optional
  @param:Experimental
  val isAdRelated: Boolean? = null,
)
