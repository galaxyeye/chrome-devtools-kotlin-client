@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Boolean
import kotlin.collections.List

/**
 * Media query descriptor.
 */
@Serializable
data class MediaQuery(
  @SerialName("expressions")
  val expressions: List<MediaQueryExpression>,
  @SerialName("active")
  val active: Boolean,
)
