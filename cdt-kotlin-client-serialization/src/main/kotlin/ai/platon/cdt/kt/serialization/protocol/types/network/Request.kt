@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.security.MixedContentType
import kotlin.Any
import kotlin.Boolean
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map

/**
 * HTTP request data.
 */
@Serializable
data class Request(
  @SerialName("url")
  val url: String,
  @SerialName("urlFragment")
  @param:Optional
  val urlFragment: String? = null,
  @SerialName("method")
  val method: String,
  @SerialName("headers")
  val headers: Map<String, Any?>,
  @SerialName("postData")
  @param:Optional
  val postData: String? = null,
  @SerialName("hasPostData")
  @param:Optional
  val hasPostData: Boolean? = null,
  @SerialName("postDataEntries")
  @param:Optional
  @param:Experimental
  val postDataEntries: List<PostDataEntry>? = null,
  @SerialName("mixedContentType")
  @param:Optional
  val mixedContentType: MixedContentType? = null,
  @SerialName("initialPriority")
  val initialPriority: ResourcePriority,
  @SerialName("referrerPolicy")
  val referrerPolicy: RequestReferrerPolicy,
  @SerialName("isLinkPreload")
  @param:Optional
  val isLinkPreload: Boolean? = null,
  @SerialName("trustTokenParams")
  @param:Optional
  @param:Experimental
  val trustTokenParams: TrustTokenParams? = null,
)
