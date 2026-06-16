@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css

import ai.platon.cdt.kt.serialization.protocol.types.dom.PseudoType
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * CSS rule collection for a single pseudo style.
 */
@Serializable
data class PseudoElementMatches(
  @property:SerialName("pseudoType")
  val pseudoType: PseudoType,
  @property:SerialName("matches")
  val matches: List<RuleMatch>,
)
