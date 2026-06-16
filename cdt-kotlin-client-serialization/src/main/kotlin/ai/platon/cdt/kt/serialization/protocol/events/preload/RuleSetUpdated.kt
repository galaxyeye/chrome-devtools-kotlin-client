@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.preload

import ai.platon.cdt.kt.serialization.protocol.types.preload.RuleSet
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Upsert. Currently, it is only emitted when a rule set added.
 */
@Serializable
data class RuleSetUpdated(
  @property:SerialName("ruleSet")
  val ruleSet: RuleSet,
)
