package ai.platon.cdt.kt.protocol.events.page

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Double
import kotlin.String

/**
 * Fired for top level page lifecycle events such as navigation, load, paint, etc.
 */
public data class LifecycleEvent(
  @field:JsonProperty("frameId")
  public val frameId: String,
  @field:JsonProperty("loaderId")
  public val loaderId: String,
  @field:JsonProperty("name")
  public val name: String,
  @field:JsonProperty("timestamp")
  public val timestamp: Double,
)
