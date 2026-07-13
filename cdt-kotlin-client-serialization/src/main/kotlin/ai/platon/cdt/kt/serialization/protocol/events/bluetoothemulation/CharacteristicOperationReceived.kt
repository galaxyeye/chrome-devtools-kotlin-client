@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.bluetoothemulation

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import ai.platon.cdt.kt.serialization.protocol.types.bluetoothemulation.CharacteristicOperationType
import ai.platon.cdt.kt.serialization.protocol.types.bluetoothemulation.CharacteristicWriteType
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Event for when a characteristic operation of |type| to the characteristic
 * respresented by |characteristicId| happened. |data| and |writeType| is
 * expected to exist when |type| is write.
 */
@Serializable
data class CharacteristicOperationReceived(
  @property:SerialName("characteristicId")
  val characteristicId: String,
  @property:SerialName("type")
  val type: CharacteristicOperationType,
  @property:SerialName("data")
  @param:Optional
  val `data`: String? = null,
  @property:SerialName("writeType")
  @param:Optional
  val writeType: CharacteristicWriteType? = null,
)
