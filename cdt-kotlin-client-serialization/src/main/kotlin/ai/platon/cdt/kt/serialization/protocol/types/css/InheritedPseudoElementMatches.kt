@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css

import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Inherited pseudo element matches from pseudos of an ancestor node.
 */
@Serializable
data class InheritedPseudoElementMatches(
  @property:SerialName("pseudoElements")
  val pseudoElements: List<PseudoElementMatches>,
)
