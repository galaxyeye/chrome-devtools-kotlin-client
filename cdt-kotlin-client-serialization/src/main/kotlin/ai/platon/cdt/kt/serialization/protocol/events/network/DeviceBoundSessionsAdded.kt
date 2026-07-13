@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.network

import ai.platon.cdt.kt.serialization.protocol.support.annotations.Experimental
import ai.platon.cdt.kt.serialization.protocol.types.network.DeviceBoundSession
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Triggered when the initial set of device bound sessions is added.
 */
@Serializable
@Experimental
data class DeviceBoundSessionsAdded(
  @property:SerialName("sessions")
  val sessions: List<DeviceBoundSession>,
)
