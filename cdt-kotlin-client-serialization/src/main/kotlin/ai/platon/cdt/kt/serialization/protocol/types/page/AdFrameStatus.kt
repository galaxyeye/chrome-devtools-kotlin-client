@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
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
