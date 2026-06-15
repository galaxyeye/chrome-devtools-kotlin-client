@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.runtime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Boolean
import kotlin.String

/**
 * Object property descriptor.
 */
@Serializable
data class PropertyDescriptor(
  @SerialName("name")
  val name: String,
  @SerialName("value")
  @param:Optional
  val `value`: RemoteObject? = null,
  @SerialName("writable")
  @param:Optional
  val writable: Boolean? = null,
  @SerialName("get")
  @param:Optional
  val `get`: RemoteObject? = null,
  @SerialName("set")
  @param:Optional
  val `set`: RemoteObject? = null,
  @SerialName("configurable")
  val configurable: Boolean,
  @SerialName("enumerable")
  val enumerable: Boolean,
  @SerialName("wasThrown")
  @param:Optional
  val wasThrown: Boolean? = null,
  @SerialName("isOwn")
  @param:Optional
  val isOwn: Boolean? = null,
  @SerialName("symbol")
  @param:Optional
  val symbol: RemoteObject? = null,
)
