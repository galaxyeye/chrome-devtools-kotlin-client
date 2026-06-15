@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.css
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import ai.platon.cdt.kt.serialization.protocol.types.dom.PseudoType
import kotlin.collections.List

/**
 * CSS rule collection for a single pseudo style.
 */
@Serializable
data class PseudoElementMatches(
  @SerialName("pseudoType")
  val pseudoType: PseudoType,
  @SerialName("matches")
  val matches: List<RuleMatch>,
)
