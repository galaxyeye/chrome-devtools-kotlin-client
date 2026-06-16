@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Enum indicating the type of a CSS rule, used to represent the order of a style rule's ancestors.
 * This list only contains rule types that are collected during the ancestor rule collection.
 */
@Serializable
public enum class CSSRuleType {
  @SerialName("MediaRule")
  MEDIA_RULE,
  @SerialName("SupportsRule")
  SUPPORTS_RULE,
  @SerialName("ContainerRule")
  CONTAINER_RULE,
  @SerialName("LayerRule")
  LAYER_RULE,
  @SerialName("ScopeRule")
  SCOPE_RULE,
  @SerialName("StyleRule")
  STYLE_RULE,
  @SerialName("StartingStyleRule")
  STARTING_STYLE_RULE,
  @SerialName("NavigationRule")
  NAVIGATION_RULE,
  UNKNOWN,
}
