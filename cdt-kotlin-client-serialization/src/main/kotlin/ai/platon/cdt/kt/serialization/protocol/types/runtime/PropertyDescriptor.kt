@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.runtime

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Boolean
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Object property descriptor.
 */
@Serializable
data class PropertyDescriptor(
  @property:SerialName("name")
  val name: String,
  @property:SerialName("value")
  @param:Optional
  val `value`: RemoteObject? = null,
  @property:SerialName("writable")
  @param:Optional
  val writable: Boolean? = null,
  @property:SerialName("get")
  @param:Optional
  val `get`: RemoteObject? = null,
  @property:SerialName("set")
  @param:Optional
  val `set`: RemoteObject? = null,
  @property:SerialName("configurable")
  val configurable: Boolean,
  @property:SerialName("enumerable")
  val enumerable: Boolean,
  @property:SerialName("wasThrown")
  @param:Optional
  val wasThrown: Boolean? = null,
  @property:SerialName("isOwn")
  @param:Optional
  val isOwn: Boolean? = null,
  @property:SerialName("symbol")
  @param:Optional
  val symbol: RemoteObject? = null,
)
