@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.dom

import com.fasterxml.jackson.`annotation`.JsonEnumDefaultValue
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * Type of relation to get.
 */
public enum class GetElementByRelationRelation {
  @JsonProperty("PopoverTarget")
  POPOVER_TARGET,
  @JsonProperty("InterestTarget")
  INTEREST_TARGET,
  @JsonProperty("CommandFor")
  COMMAND_FOR,
  @JsonEnumDefaultValue
  UNKNOWN,
}
