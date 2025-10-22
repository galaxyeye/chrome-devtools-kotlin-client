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
public data class Request(
  @field:JsonProperty("url")
  public val url: String,
  @field:JsonProperty("urlFragment")
  @param:Optional
  public val urlFragment: String? = null,
  @field:JsonProperty("method")
  public val method: String,
  @field:JsonProperty("headers")
  public val headers: Map<String, Any?>,
  @field:JsonProperty("postData")
  @param:Optional
  public val postData: String? = null,
  @field:JsonProperty("hasPostData")
  @param:Optional
  public val hasPostData: Boolean? = null,
  @field:JsonProperty("postDataEntries")
  @param:Optional
  @param:Experimental
  public val postDataEntries: List<PostDataEntry>? = null,
  @field:JsonProperty("mixedContentType")
  @param:Optional
  public val mixedContentType: MixedContentType? = null,
  @field:JsonProperty("initialPriority")
  public val initialPriority: ResourcePriority,
  @field:JsonProperty("referrerPolicy")
  public val referrerPolicy: RequestReferrerPolicy,
  @field:JsonProperty("isLinkPreload")
  @param:Optional
  public val isLinkPreload: Boolean? = null,
  @field:JsonProperty("trustTokenParams")
  @param:Optional
  @param:Experimental
  public val trustTokenParams: TrustTokenParams? = null,
)
