@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.page

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

public enum class AdFrameExplanation {
  @JsonProperty("ParentIsAd")
  PARENT_IS_AD,
  @JsonProperty("CreatedByAdScript")
  CREATED_BY_AD_SCRIPT,
  @JsonProperty("MatchedBlockingRule")
  MATCHED_BLOCKING_RULE,
  @JsonEnumDefaultValue
  UNKNOWN,
}
