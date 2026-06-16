@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.runtime

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Object private field descriptor.
 */
@Serializable
@Experimental
data class PrivatePropertyDescriptor(
  @property:SerialName("name")
  val name: String,
  @property:SerialName("value")
  @param:Optional
  val `value`: RemoteObject? = null,
  @property:SerialName("get")
  @param:Optional
  val `get`: RemoteObject? = null,
  @property:SerialName("set")
  @param:Optional
  val `set`: RemoteObject? = null,
)
