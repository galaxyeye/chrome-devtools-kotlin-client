package ai.platon.cdt.kt.protocol.types.runtime

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.support.annotations.Optional
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Object private field descriptor.
 */
@Experimental
data class PrivatePropertyDescriptor(
  @field:JsonProperty("name")
  val name: String,
  @field:JsonProperty("value")
  @param:Optional
  val `value`: RemoteObject? = null,
  @field:JsonProperty("get")
  @param:Optional
  val `get`: RemoteObject? = null,
  @field:JsonProperty("set")
  @param:Optional
  val `set`: RemoteObject? = null,
)
