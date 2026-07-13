@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.page

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.collections.List

/**
 * Indicates whether a frame has been identified as an ad and why.
 */
@Experimental
data class AdFrameStatus(
  @param:JsonProperty("adFrameType")
  val adFrameType: AdFrameType,
  @param:JsonProperty("explanations")
  @param:Optional
  val explanations: List<AdFrameExplanation>? = null,
)
