package ai.platon.cdt.kt.protocol.types.runtime

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Object private field descriptor.
 */
@Experimental
public data class PrivatePropertyDescriptor(
  @field:JsonProperty("name")
  public val name: String,
  @field:JsonProperty("value")
  @param:Optional
  public val `value`: RemoteObject? = null,
  @field:JsonProperty("get")
  @param:Optional
  public val `get`: RemoteObject? = null,
  @field:JsonProperty("set")
  @param:Optional
  public val `set`: RemoteObject? = null,
)
