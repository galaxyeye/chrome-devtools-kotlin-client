package ai.platon.cdt.kt.protocol.events.target

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Issued when a target is destroyed.
 */
data class TargetDestroyed(
  @field:JsonProperty("targetId")
  val targetId: String,
)
