@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.page

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String
import kotlin.collections.List

@Experimental
data class BackForwardCacheNotRestoredExplanation(
  @param:JsonProperty("type")
  val type: BackForwardCacheNotRestoredReasonType,
  @param:JsonProperty("reason")
  val reason: BackForwardCacheNotRestoredReason,
  @param:JsonProperty("context")
  @param:Optional
  val context: String? = null,
  @param:JsonProperty("details")
  @param:Optional
  val details: List<BackForwardCacheBlockingDetails>? = null,
)
