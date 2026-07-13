@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.page

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String
import kotlin.collections.List

@Experimental
data class BackForwardCacheNotRestoredExplanationTree(
  @param:JsonProperty("url")
  val url: String,
  @param:JsonProperty("explanations")
  val explanations: List<BackForwardCacheNotRestoredExplanation>,
  @param:JsonProperty("children")
  val children: List<BackForwardCacheNotRestoredExplanationTree>,
)
