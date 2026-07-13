@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.bluetoothemulation

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.bluetoothemulation.DescriptorOperationType
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Event for when a descriptor operation of |type| to the descriptor
 * respresented by |descriptorId| happened. |data| is expected to exist when
 * |type| is write.
 */
data class DescriptorOperationReceived(
  @param:JsonProperty("descriptorId")
  val descriptorId: String,
  @param:JsonProperty("type")
  val type: DescriptorOperationType,
  @param:JsonProperty("data")
  @param:Optional
  val `data`: String? = null,
)
