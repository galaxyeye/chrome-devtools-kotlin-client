@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.bluetoothemulation

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Boolean
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Describes the properties of a characteristic. This follows Bluetooth Core
 * Specification BT 4.2 Vol 3 Part G 3.3.1. Characteristic Properties.
 */
@Serializable
data class CharacteristicProperties(
  @property:SerialName("broadcast")
  @param:Optional
  val broadcast: Boolean? = null,
  @property:SerialName("read")
  @param:Optional
  val read: Boolean? = null,
  @property:SerialName("writeWithoutResponse")
  @param:Optional
  val writeWithoutResponse: Boolean? = null,
  @property:SerialName("write")
  @param:Optional
  val write: Boolean? = null,
  @property:SerialName("notify")
  @param:Optional
  val notify: Boolean? = null,
  @property:SerialName("indicate")
  @param:Optional
  val indicate: Boolean? = null,
  @property:SerialName("authenticatedSignedWrites")
  @param:Optional
  val authenticatedSignedWrites: Boolean? = null,
  @property:SerialName("extendedProperties")
  @param:Optional
  val extendedProperties: Boolean? = null,
)
