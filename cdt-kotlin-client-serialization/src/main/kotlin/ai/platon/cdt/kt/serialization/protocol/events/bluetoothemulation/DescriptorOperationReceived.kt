@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.bluetoothemulation

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.bluetoothemulation.DescriptorOperationType
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Event for when a descriptor operation of |type| to the descriptor
 * respresented by |descriptorId| happened. |data| is expected to exist when
 * |type| is write.
 */
@Serializable
data class DescriptorOperationReceived(
  @property:SerialName("descriptorId")
  val descriptorId: String,
  @property:SerialName("type")
  val type: DescriptorOperationType,
  @property:SerialName("data")
  @param:Optional
  val `data`: String? = null,
)
