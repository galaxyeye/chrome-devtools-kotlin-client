@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.network

import ai.platon.cdt.kt.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.protocol.types.network.DeviceBoundSession
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.collections.List

/**
 * Triggered when the initial set of device bound sessions is added.
 */
@Experimental
data class DeviceBoundSessionsAdded(
  @param:JsonProperty("sessions")
  val sessions: List<DeviceBoundSession>,
)
