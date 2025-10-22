package ai.platon.cdt.kt.protocol.events.target

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

/**
 * Issued when a target has crashed.
 */
public data class TargetCrashed(
  @field:JsonProperty("targetId")
  public val targetId: String,
  @field:JsonProperty("status")
  public val status: String,
  @field:JsonProperty("errorCode")
  public val errorCode: Int,
)
