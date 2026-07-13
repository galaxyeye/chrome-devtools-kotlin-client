@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.css

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int

/**
 * Specificity:
 * https://drafts.csswg.org/selectors/#specificity-rules
 */
@Experimental
data class Specificity(
  @param:JsonProperty("a")
  val a: Int,
  @param:JsonProperty("b")
  val b: Int,
  @param:JsonProperty("c")
  val c: Int,
)
