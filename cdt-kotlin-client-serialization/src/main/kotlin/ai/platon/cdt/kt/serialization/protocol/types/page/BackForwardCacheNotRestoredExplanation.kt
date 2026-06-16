@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@Experimental
data class BackForwardCacheNotRestoredExplanation(
  @property:SerialName("type")
  val type: BackForwardCacheNotRestoredReasonType,
  @property:SerialName("reason")
  val reason: BackForwardCacheNotRestoredReason,
  @property:SerialName("context")
  @param:Optional
  val context: String? = null,
  @property:SerialName("details")
  @param:Optional
  val details: List<BackForwardCacheBlockingDetails>? = null,
)
