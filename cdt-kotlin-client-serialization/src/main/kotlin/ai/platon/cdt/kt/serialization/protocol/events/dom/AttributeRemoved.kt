@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.dom
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Int
import kotlin.String

/**
 * Fired when `Element`'s attribute is removed.
 */
@Serializable
data class AttributeRemoved(
  @SerialName("nodeId")
  val nodeId: Int,
  @SerialName("name")
  val name: String,
)
