package ai.platon.cdt.kt.protocol.types.backgroundservice

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * A key-value pair for additional event information to pass along.
 */
public data class EventMetadata(
  @field:JsonProperty("key")
  public val key: String,
  @field:JsonProperty("value")
  public val `value`: String,
)
