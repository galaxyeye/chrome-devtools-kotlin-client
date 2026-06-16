@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.dom

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Double
import kotlin.Int
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * A structure holding an RGBA color.
 */
@Serializable
data class RGBA(
  @property:SerialName("r")
  val r: Int,
  @property:SerialName("g")
  val g: Int,
  @property:SerialName("b")
  val b: Int,
  @property:SerialName("a")
  @param:Optional
  val a: Double? = null,
)
