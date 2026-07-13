@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import kotlin.Int
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Specificity:
 * https://drafts.csswg.org/selectors/#specificity-rules
 */
@Serializable
@Experimental
data class Specificity(
  @property:SerialName("a")
  val a: Int,
  @property:SerialName("b")
  val b: Int,
  @property:SerialName("c")
  val c: Int,
)
