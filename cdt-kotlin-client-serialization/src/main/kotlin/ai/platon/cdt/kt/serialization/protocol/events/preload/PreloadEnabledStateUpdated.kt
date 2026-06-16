@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.preload

import kotlin.Boolean
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Fired when a preload enabled state is updated.
 */
@Serializable
data class PreloadEnabledStateUpdated(
  @property:SerialName("disabledByPreference")
  val disabledByPreference: Boolean,
  @property:SerialName("disabledByDataSaver")
  val disabledByDataSaver: Boolean,
  @property:SerialName("disabledByBatterySaver")
  val disabledByBatterySaver: Boolean,
  @property:SerialName("disabledByHoldbackPrefetchSpeculationRules")
  val disabledByHoldbackPrefetchSpeculationRules: Boolean,
  @property:SerialName("disabledByHoldbackPrerenderSpeculationRules")
  val disabledByHoldbackPrerenderSpeculationRules: Boolean,
)
