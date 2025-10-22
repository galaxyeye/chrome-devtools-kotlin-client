package ai.platon.cdt.kt.protocol.types.runtime

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.String

/**
 * Object property descriptor.
 */
data class PropertyDescriptor(
  @field:JsonProperty("name")
  val name: String,
  @field:JsonProperty("value")
  @param:Optional
  val `value`: RemoteObject? = null,
  @field:JsonProperty("writable")
  @param:Optional
  val writable: Boolean? = null,
  @field:JsonProperty("get")
  @param:Optional
  val `get`: RemoteObject? = null,
  @field:JsonProperty("set")
  @param:Optional
  val `set`: RemoteObject? = null,
  @field:JsonProperty("configurable")
  val configurable: Boolean,
  @field:JsonProperty("enumerable")
  val enumerable: Boolean,
  @field:JsonProperty("wasThrown")
  @param:Optional
  val wasThrown: Boolean? = null,
  @field:JsonProperty("isOwn")
  @param:Optional
  val isOwn: Boolean? = null,
  @field:JsonProperty("symbol")
  @param:Optional
  val symbol: RemoteObject? = null,
)
