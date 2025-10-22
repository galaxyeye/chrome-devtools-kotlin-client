package ai.platon.cdt.kt.protocol.events.applicationcache

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

public data class ApplicationCacheStatusUpdated(
  @field:JsonProperty("frameId")
  public val frameId: String,
  @field:JsonProperty("manifestURL")
  public val manifestURL: String,
  @field:JsonProperty("status")
  public val status: Int,
)
