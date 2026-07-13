@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.css

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * Enum indicating the type of a CSS rule, used to represent the order of a style rule's ancestors.
 * This list only contains rule types that are collected during the ancestor rule collection.
 */
public enum class CSSRuleType {
  @JsonProperty("MediaRule")
  MEDIA_RULE,
  @JsonProperty("SupportsRule")
  SUPPORTS_RULE,
  @JsonProperty("ContainerRule")
  CONTAINER_RULE,
  @JsonProperty("LayerRule")
  LAYER_RULE,
  @JsonProperty("ScopeRule")
  SCOPE_RULE,
  @JsonProperty("StyleRule")
  STYLE_RULE,
  @JsonProperty("StartingStyleRule")
  STARTING_STYLE_RULE,
  @JsonProperty("NavigationRule")
  NAVIGATION_RULE,
  @JsonEnumDefaultValue
  UNKNOWN,
}
