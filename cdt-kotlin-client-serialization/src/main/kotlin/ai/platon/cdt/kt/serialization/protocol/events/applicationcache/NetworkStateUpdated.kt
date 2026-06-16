@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.applicationcache

import kotlin.Boolean
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkStateUpdated(
  @property:SerialName("isNowOnline")
  val isNowOnline: Boolean,
)
