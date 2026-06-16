@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.bluetoothemulation

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean

/**
 * Describes the properties of a characteristic. This follows Bluetooth Core
 * Specification BT 4.2 Vol 3 Part G 3.3.1. Characteristic Properties.
 */
data class CharacteristicProperties(
  @param:JsonProperty("broadcast")
  @param:Optional
  val broadcast: Boolean? = null,
  @param:JsonProperty("read")
  @param:Optional
  val read: Boolean? = null,
  @param:JsonProperty("writeWithoutResponse")
  @param:Optional
  val writeWithoutResponse: Boolean? = null,
  @param:JsonProperty("write")
  @param:Optional
  val write: Boolean? = null,
  @param:JsonProperty("notify")
  @param:Optional
  val notify: Boolean? = null,
  @param:JsonProperty("indicate")
  @param:Optional
  val indicate: Boolean? = null,
  @param:JsonProperty("authenticatedSignedWrites")
  @param:Optional
  val authenticatedSignedWrites: Boolean? = null,
  @param:JsonProperty("extendedProperties")
  @param:Optional
  val extendedProperties: Boolean? = null,
)
