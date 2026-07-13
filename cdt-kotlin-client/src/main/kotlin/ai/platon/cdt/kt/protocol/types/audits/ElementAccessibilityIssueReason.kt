@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.audits

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

public enum class ElementAccessibilityIssueReason {
  @JsonProperty("DisallowedSelectChild")
  DISALLOWED_SELECT_CHILD,
  @JsonProperty("DisallowedOptGroupChild")
  DISALLOWED_OPT_GROUP_CHILD,
  @JsonProperty("NonPhrasingContentOptionChild")
  NON_PHRASING_CONTENT_OPTION_CHILD,
  @JsonProperty("InteractiveContentOptionChild")
  INTERACTIVE_CONTENT_OPTION_CHILD,
  @JsonProperty("InteractiveContentLegendChild")
  INTERACTIVE_CONTENT_LEGEND_CHILD,
  @JsonProperty("InteractiveContentSummaryDescendant")
  INTERACTIVE_CONTENT_SUMMARY_DESCENDANT,
  @JsonEnumDefaultValue
  UNKNOWN,
}
