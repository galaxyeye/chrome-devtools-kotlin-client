package ai.platon.cdt.kt.protocol.types.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.security.MixedContentType
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Any
import kotlin.Boolean
import kotlin.String
import kotlin.collections.List
import kotlin.collections.Map

/**
 * HTTP request data.
 */
data class Request(
  @field:JsonProperty("url")
  val url: String,
  @field:JsonProperty("urlFragment")
  @param:Optional
  val urlFragment: String? = null,
  @field:JsonProperty("method")
  val method: String,
  @field:JsonProperty("headers")
  val headers: Map<String, Any?>,
  @field:JsonProperty("postData")
  @param:Optional
  val postData: String? = null,
  @field:JsonProperty("hasPostData")
  @param:Optional
  val hasPostData: Boolean? = null,
  @field:JsonProperty("postDataEntries")
  @param:Optional
  @param:Experimental
  val postDataEntries: List<PostDataEntry>? = null,
  @field:JsonProperty("mixedContentType")
  @param:Optional
  val mixedContentType: MixedContentType? = null,
  @field:JsonProperty("initialPriority")
  val initialPriority: ResourcePriority,
  @field:JsonProperty("referrerPolicy")
  val referrerPolicy: RequestReferrerPolicy,
  @field:JsonProperty("isLinkPreload")
  @param:Optional
  val isLinkPreload: Boolean? = null,
  @field:JsonProperty("trustTokenParams")
  @param:Optional
  @param:Experimental
  val trustTokenParams: TrustTokenParams? = null,
)
