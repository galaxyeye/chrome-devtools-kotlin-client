@file:Suppress("unused")
package ai.platon.cdt.kt.protocol.events.preload

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

data class RuleSetRemoved(
  @param:JsonProperty("id")
  val id: String,
)
