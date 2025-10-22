package ai.platon.cdt.kt.protocol.types.network

import com.fasterxml.jackson.`annotation`.JsonProperty
import kotlin.String

data class CorsErrorStatus(
  @field:JsonProperty("corsError")
  val corsError: CorsError,
  @field:JsonProperty("failedParameter")
  val failedParameter: String,
)
