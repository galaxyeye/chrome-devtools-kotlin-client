@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.preload

import ai.platon.cdt.kt.protocol.types.preload.RuleSet
import com.fasterxml.jackson.`annotation`.JsonProperty

/**
 * Upsert. Currently, it is only emitted when a rule set added.
 */
data class RuleSetUpdated(
  @param:JsonProperty("ruleSet")
  val ruleSet: RuleSet,
)
