package ai.platon.cdt.kt.protocol.events.profiler

import ai.platon.cdt.kt.protocol.support.annotations.Optional
import ai.platon.cdt.kt.protocol.types.debugger.Location
import ai.platon.cdt.kt.protocol.types.profiler.Profile
import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

public data class ConsoleProfileFinished(
  @field:JsonProperty("id")
  public val id: String,
  @field:JsonProperty("location")
  public val location: Location,
  @field:JsonProperty("profile")
  public val profile: Profile,
  @field:JsonProperty("title")
  @param:Optional
  public val title: String? = null,
)
