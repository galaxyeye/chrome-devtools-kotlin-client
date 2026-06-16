@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

/**
 * Details about a failed device bound session network request.
 */
@Experimental
data class DeviceBoundSessionFailedRequest(
  @param:JsonProperty("requestUrl")
  val requestUrl: String,
  @param:JsonProperty("netError")
  @param:Optional
  val netError: String? = null,
  @param:JsonProperty("responseError")
  @param:Optional
  val responseError: Int? = null,
  @param:JsonProperty("responseErrorBody")
  @param:Optional
  val responseErrorBody: String? = null,
)
