package ai.platon.cdt.kt.protocol.events.applicationcache

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.Int
import kotlin.String

data class ApplicationCacheStatusUpdated(
  @field:JsonProperty("frameId")
  val frameId: String,
  @field:JsonProperty("manifestURL")
  val manifestURL: String,
  @field:JsonProperty("status")
  val status: Int,
)
