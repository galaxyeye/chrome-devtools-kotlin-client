@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.types.css

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.collections.List

/**
 * Inherited pseudo element matches from pseudos of an ancestor node.
 */
data class InheritedPseudoElementMatches(
  @param:JsonProperty("pseudoElements")
  val pseudoElements: List<PseudoElementMatches>,
)
