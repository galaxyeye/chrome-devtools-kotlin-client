@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.accessibility

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * Enum of possible property sources.
 */
public enum class AXValueSourceType {
  @JsonProperty("attribute")
  ATTRIBUTE,
  @JsonProperty("implicit")
  IMPLICIT,
  @JsonProperty("style")
  STYLE,
  @JsonProperty("contents")
  CONTENTS,
  @JsonProperty("placeholder")
  PLACEHOLDER,
  @JsonProperty("relatedElement")
  RELATED_ELEMENT,
  @JsonEnumDefaultValue
  UNKNOWN,
}
