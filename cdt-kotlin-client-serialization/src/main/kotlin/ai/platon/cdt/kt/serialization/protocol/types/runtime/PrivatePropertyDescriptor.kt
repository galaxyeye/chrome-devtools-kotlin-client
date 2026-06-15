@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.runtime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String

/**
 * Object private field descriptor.
 */
@Experimental
@Serializable
data class PrivatePropertyDescriptor(
  @SerialName("name")
  val name: String,
  @SerialName("value")
  @param:Optional
  val `value`: RemoteObject? = null,
  @SerialName("get")
  @param:Optional
  val `get`: RemoteObject? = null,
  @SerialName("set")
  @param:Optional
  val `set`: RemoteObject? = null,
)
