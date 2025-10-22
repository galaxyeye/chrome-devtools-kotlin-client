package ai.platon.cdt.kt.protocol.events.profiler

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.debugger.Location
import ai.platon.cdt.kt.protocol.types.profiler.Profile
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

data class ConsoleProfileFinished(
  @field:JsonProperty("id")
  val id: String,
  @field:JsonProperty("location")
  val location: Location,
  @field:JsonProperty("profile")
  val profile: Profile,
  @field:JsonProperty("title")
  @param:Optional
  val title: String? = null,
)
