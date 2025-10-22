package ai.platon.cdt.kt.protocol.types.network

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

public data class CorsErrorStatus(
  @field:JsonProperty("corsError")
  public val corsError: CorsError,
  @field:JsonProperty("failedParameter")
  public val failedParameter: String,
)
