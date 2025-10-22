package ai.platon.cdt.kt.protocol.events.target

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

/**
 * Issued when a target has crashed.
 */
data class TargetCrashed(
  @field:JsonProperty("targetId")
  val targetId: String,
  @field:JsonProperty("status")
  val status: String,
  @field:JsonProperty("errorCode")
  val errorCode: Int,
)
