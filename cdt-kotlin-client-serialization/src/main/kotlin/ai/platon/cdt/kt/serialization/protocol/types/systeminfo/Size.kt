@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.systeminfo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Int

/**
 * Describes the width and height dimensions of an entity.
 */
@Serializable
data class Size(
  @SerialName("width")
  val width: Int,
  @SerialName("height")
  val height: Int,
)
