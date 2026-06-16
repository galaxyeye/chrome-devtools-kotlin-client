@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.audits

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class ElementAccessibilityIssueReason {
  @SerialName("DisallowedSelectChild")
  DISALLOWED_SELECT_CHILD,
  @SerialName("DisallowedOptGroupChild")
  DISALLOWED_OPT_GROUP_CHILD,
  @SerialName("NonPhrasingContentOptionChild")
  NON_PHRASING_CONTENT_OPTION_CHILD,
  @SerialName("InteractiveContentOptionChild")
  INTERACTIVE_CONTENT_OPTION_CHILD,
  @SerialName("InteractiveContentLegendChild")
  INTERACTIVE_CONTENT_LEGEND_CHILD,
  @SerialName("InteractiveContentSummaryDescendant")
  INTERACTIVE_CONTENT_SUMMARY_DESCENDANT,
  UNKNOWN,
}
