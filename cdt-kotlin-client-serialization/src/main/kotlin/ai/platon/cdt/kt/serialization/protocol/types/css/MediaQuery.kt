@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css

import kotlin.Boolean
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Media query descriptor.
 */
@Serializable
data class MediaQuery(
  @property:SerialName("expressions")
  val expressions: List<MediaQueryExpression>,
  @property:SerialName("active")
  val active: Boolean,
)
