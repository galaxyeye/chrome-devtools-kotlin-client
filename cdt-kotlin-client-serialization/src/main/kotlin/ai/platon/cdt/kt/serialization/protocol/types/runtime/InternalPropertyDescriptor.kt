@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.runtime

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Object internal property descriptor. This property isn't normally visible in JavaScript code.
 */
@Serializable
data class InternalPropertyDescriptor(
  @property:SerialName("name")
  val name: String,
  @property:SerialName("value")
  @param:Optional
  val `value`: RemoteObject? = null,
)
