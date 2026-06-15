@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.applicationcache
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.Boolean

@Serializable
data class NetworkStateUpdated(
  @SerialName("isNowOnline")
  val isNowOnline: Boolean,
)
