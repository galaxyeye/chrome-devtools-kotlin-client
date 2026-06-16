@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.page

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class AdFrameExplanation {
  @SerialName("ParentIsAd")
  PARENT_IS_AD,
  @SerialName("CreatedByAdScript")
  CREATED_BY_AD_SCRIPT,
  @SerialName("MatchedBlockingRule")
  MATCHED_BLOCKING_RULE,
  UNKNOWN,
}
