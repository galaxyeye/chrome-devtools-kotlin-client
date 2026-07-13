@file:Suppress("unused")
package ai.platon.browser4.chrome.protocol.types.page

import ai.platon.browser4.chrome.protocol.support.annotations.Experimental
import ai.platon.browser4.chrome.protocol.support.annotations.Optional
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Indicates whether a frame has been identified as an ad and why.
 */
@Serializable
@Experimental
data class AdFrameStatus(
  @property:SerialName("adFrameType")
  val adFrameType: AdFrameType,
  @property:SerialName("explanations")
  @param:Optional
  val explanations: List<AdFrameExplanation>? = null,
)
