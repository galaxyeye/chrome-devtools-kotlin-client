package ai.platon.cdt.kt.protocol.types.css

import ai.platon.cdt.kt.protocol.types.dom.PseudoType
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.collections.List

/**
 * CSS rule collection for a single pseudo style.
 */
data class PseudoElementMatches(
  @field:JsonProperty("pseudoType")
  val pseudoType: PseudoType,
  @field:JsonProperty("matches")
  val matches: List<RuleMatch>,
)
