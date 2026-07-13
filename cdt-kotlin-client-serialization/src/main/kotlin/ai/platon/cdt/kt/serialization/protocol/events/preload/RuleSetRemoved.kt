@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.events.preload

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RuleSetRemoved(
  @property:SerialName("id")
  val id: String,
)
