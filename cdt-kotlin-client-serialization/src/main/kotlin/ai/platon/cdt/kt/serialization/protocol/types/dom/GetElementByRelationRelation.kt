@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.dom

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Type of relation to get.
 */
@Serializable
public enum class GetElementByRelationRelation {
  @SerialName("PopoverTarget")
  POPOVER_TARGET,
  @SerialName("InterestTarget")
  INTEREST_TARGET,
  @SerialName("CommandFor")
  COMMAND_FOR,
  UNKNOWN,
}
