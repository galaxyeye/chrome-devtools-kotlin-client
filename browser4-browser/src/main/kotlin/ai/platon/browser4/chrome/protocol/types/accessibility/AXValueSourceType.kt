@file:Suppress("unused")
package ai.platon.browser4.chrome.protocol.types.accessibility

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Enum of possible property sources.
 */
@Serializable
public enum class AXValueSourceType {
  @SerialName("attribute")
  ATTRIBUTE,
  @SerialName("implicit")
  IMPLICIT,
  @SerialName("style")
  STYLE,
  @SerialName("contents")
  CONTENTS,
  @SerialName("placeholder")
  PLACEHOLDER,
  @SerialName("relatedElement")
  RELATED_ELEMENT,
  UNKNOWN,
}
