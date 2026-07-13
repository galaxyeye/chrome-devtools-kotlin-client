@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.bluetoothemulation

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.bluetoothemulation.CharacteristicOperationType
import ai.platon.cdt.kt.protocol.types.bluetoothemulation.CharacteristicWriteType
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Event for when a characteristic operation of |type| to the characteristic
 * respresented by |characteristicId| happened. |data| and |writeType| is
 * expected to exist when |type| is write.
 */
data class CharacteristicOperationReceived(
  @param:JsonProperty("characteristicId")
  val characteristicId: String,
  @param:JsonProperty("type")
  val type: CharacteristicOperationType,
  @param:JsonProperty("data")
  @param:Optional
  val `data`: String? = null,
  @param:JsonProperty("writeType")
  @param:Optional
  val writeType: CharacteristicWriteType? = null,
)
