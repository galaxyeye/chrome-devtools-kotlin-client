package ai.platon.cdt.kt.protocol.types.runtime

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean
import kotlin.String

/**
 * Object property descriptor.
 */
public data class PropertyDescriptor(
  @field:JsonProperty("name")
  public val name: String,
  @field:JsonProperty("value")
  @param:Optional
  public val `value`: RemoteObject? = null,
  @field:JsonProperty("writable")
  @param:Optional
  public val writable: Boolean? = null,
  @field:JsonProperty("get")
  @param:Optional
  public val `get`: RemoteObject? = null,
  @field:JsonProperty("set")
  @param:Optional
  public val `set`: RemoteObject? = null,
  @field:JsonProperty("configurable")
  public val configurable: Boolean,
  @field:JsonProperty("enumerable")
  public val enumerable: Boolean,
  @field:JsonProperty("wasThrown")
  @param:Optional
  public val wasThrown: Boolean? = null,
  @field:JsonProperty("isOwn")
  @param:Optional
  public val isOwn: Boolean? = null,
  @field:JsonProperty("symbol")
  @param:Optional
  public val symbol: RemoteObject? = null,
)
