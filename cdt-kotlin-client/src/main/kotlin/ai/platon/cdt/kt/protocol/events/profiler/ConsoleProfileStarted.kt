package ai.platon.cdt.kt.protocol.events.profiler

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.debugger.Location
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

/**
 * Sent when new profile recording is started using console.profile() call.
 */
data class ConsoleProfileStarted(
  @field:JsonProperty("id")
  val id: String,
  @field:JsonProperty("location")
  val location: Location,
  @field:JsonProperty("title")
  @param:Optional
  val title: String? = null,
)
