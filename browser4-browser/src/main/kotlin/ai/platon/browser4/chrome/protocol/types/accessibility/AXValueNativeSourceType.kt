@file:Suppress("unused")
package ai.platon.browser4.chrome.protocol.types.accessibility

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Enum of possible native property sources (as a subtype of a particular AXValueSourceType).
 */
@Serializable
public enum class AXValueNativeSourceType {
  @SerialName("description")
  DESCRIPTION,
  @SerialName("figcaption")
  FIGCAPTION,
  @SerialName("label")
  LABEL,
  @SerialName("labelfor")
  LABELFOR,
  @SerialName("labelwrapped")
  LABELWRAPPED,
  @SerialName("legend")
  LEGEND,
  @SerialName("rubyannotation")
  RUBYANNOTATION,
  @SerialName("tablecaption")
  TABLECAPTION,
  @SerialName("title")
  TITLE,
  @SerialName("other")
  OTHER,
  UNKNOWN,
}
