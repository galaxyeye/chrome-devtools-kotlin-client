@file:Suppress("unused")
package ai.platon.cdt.kt.serialization.protocol.types.network
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

import kotlin.String

@Serializable
data class CorsErrorStatus(
  @SerialName("corsError")
  val corsError: CorsError,
  @SerialName("failedParameter")
  val failedParameter: String,
)
