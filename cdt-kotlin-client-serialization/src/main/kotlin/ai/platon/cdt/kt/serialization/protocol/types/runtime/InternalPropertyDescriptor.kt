@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.runtime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.String

/**
 * Object internal property descriptor. This property isn't normally visible in JavaScript code.
 */
@Serializable
data class InternalPropertyDescriptor(
  @SerialName("name")
  val name: String,
  @SerialName("value")
  @param:Optional
  val `value`: RemoteObject? = null,
)
