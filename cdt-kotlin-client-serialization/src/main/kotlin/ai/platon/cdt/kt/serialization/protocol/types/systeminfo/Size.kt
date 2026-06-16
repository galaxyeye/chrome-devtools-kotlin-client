@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.systeminfo

import kotlin.Int
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Describes the width and height dimensions of an entity.
 */
@Serializable
data class Size(
  @property:SerialName("width")
  val width: Int,
  @property:SerialName("height")
  val height: Int,
)
