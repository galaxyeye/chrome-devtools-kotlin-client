@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.preload

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Boolean

/**
 * Fired when a preload enabled state is updated.
 */
data class PreloadEnabledStateUpdated(
  @param:JsonProperty("disabledByPreference")
  val disabledByPreference: Boolean,
  @param:JsonProperty("disabledByDataSaver")
  val disabledByDataSaver: Boolean,
  @param:JsonProperty("disabledByBatterySaver")
  val disabledByBatterySaver: Boolean,
  @param:JsonProperty("disabledByHoldbackPrefetchSpeculationRules")
  val disabledByHoldbackPrefetchSpeculationRules: Boolean,
  @param:JsonProperty("disabledByHoldbackPrerenderSpeculationRules")
  val disabledByHoldbackPrerenderSpeculationRules: Boolean,
)
