@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.dom
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Optional
import kotlin.Double
import kotlin.Int

/**
 * A structure holding an RGBA color.
 */
@Serializable
data class RGBA(
  @SerialName("r")
  val r: Int,
  @SerialName("g")
  val g: Int,
  @SerialName("b")
  val b: Int,
  @SerialName("a")
  @param:Optional
  val a: Double? = null,
)
